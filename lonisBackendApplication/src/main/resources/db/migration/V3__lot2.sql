-- =========================================================
-- Lot 2 : domaine Réseau
-- Commercial, SiteCommercial, Visite, Objectif, Evaluation
-- =========================================================

CREATE TABLE commerciaux (
    id              BIGSERIAL    PRIMARY KEY,
    nom             VARCHAR(255) NOT NULL,
    prenoms         VARCHAR(255),
    telephone       VARCHAR(32),
    email           VARCHAR(255),
    matricule       VARCHAR(64)  UNIQUE,
    statut          VARCHAR(32)  NOT NULL DEFAULT 'ACTIF',
    superviseur_id  BIGINT       REFERENCES commerciaux (id) ON DELETE SET NULL,
    agence_id       BIGINT,
    created_at      TIMESTAMP    NOT NULL DEFAULT now(),
    updated_at      TIMESTAMP    NOT NULL DEFAULT now()
);

CREATE INDEX idx_commerciaux_superviseur ON commerciaux (superviseur_id);
CREATE INDEX idx_commerciaux_statut      ON commerciaux (statut);

CREATE TABLE site_commerciaux (
    id            BIGSERIAL    PRIMARY KEY,
    site_id       BIGINT       NOT NULL REFERENCES sites        (id) ON DELETE CASCADE,
    commercial_id BIGINT       NOT NULL REFERENCES commerciaux  (id) ON DELETE CASCADE,
    date_debut    DATE         NOT NULL,
    date_fin      DATE,
    is_principal  BOOLEAN      NOT NULL DEFAULT FALSE,
    created_at    TIMESTAMP    NOT NULL DEFAULT now(),
    updated_at    TIMESTAMP    NOT NULL DEFAULT now(),
    CONSTRAINT uq_site_commercial_actif UNIQUE (site_id, commercial_id)
);

CREATE INDEX idx_sc_site       ON site_commerciaux (site_id);
CREATE INDEX idx_sc_commercial ON site_commerciaux (commercial_id);

CREATE TABLE visites (
    id            BIGSERIAL    PRIMARY KEY,
    commercial_id BIGINT       NOT NULL REFERENCES commerciaux (id) ON DELETE CASCADE,
    terminal_id   BIGINT       NOT NULL REFERENCES terminals   (id) ON DELETE CASCADE,
    latitude      DOUBLE PRECISION,
    longitude     DOUBLE PRECISION,
    statut        VARCHAR(32)  NOT NULL DEFAULT 'PLANIFIEE',     -- PLANIFIEE | EFFECTUEE | MANQUEE
    type_controle VARCHAR(32),                                    -- GPS | RFID | TAG
    date_visite   TIMESTAMP    NOT NULL,
    compte_rendu  TEXT,
    created_at    TIMESTAMP    NOT NULL DEFAULT now(),
    updated_at    TIMESTAMP    NOT NULL DEFAULT now()
);

CREATE INDEX idx_visites_commercial      ON visites (commercial_id);
CREATE INDEX idx_visites_terminal        ON visites (terminal_id);
CREATE INDEX idx_visites_statut          ON visites (statut);
CREATE INDEX idx_visites_date            ON visites (date_visite DESC);
CREATE INDEX idx_visites_commercial_date ON visites (commercial_id, date_visite DESC);

CREATE TABLE objectifs (
    id            BIGSERIAL    PRIMARY KEY,
    commercial_id BIGINT       NOT NULL REFERENCES commerciaux (id) ON DELETE CASCADE,
    type          VARCHAR(32)  NOT NULL,         -- VISITE | VENTE
    periode       VARCHAR(32)  NOT NULL,         -- MENSUEL | TRIMESTRIEL
    valeur_cible  INT          NOT NULL,
    valeur_reelle INT          NOT NULL DEFAULT 0,
    mois          INT,
    trimestre     INT,
    annee         INT          NOT NULL,
    created_at    TIMESTAMP    NOT NULL DEFAULT now(),
    updated_at    TIMESTAMP    NOT NULL DEFAULT now()
);

CREATE INDEX idx_objectifs_commercial      ON objectifs (commercial_id);
CREATE INDEX idx_objectifs_annee           ON objectifs (annee DESC);
CREATE INDEX idx_objectifs_commercial_year ON objectifs (commercial_id, annee, mois);

CREATE TABLE evaluations (
    id                    BIGSERIAL        PRIMARY KEY,
    commercial_id         BIGINT           NOT NULL REFERENCES commerciaux (id) ON DELETE CASCADE,
    nb_visites_prevues    INT              NOT NULL DEFAULT 0,
    nb_visites_effectuees INT              NOT NULL DEFAULT 0,
    taux_realisation      DOUBLE PRECISION NOT NULL DEFAULT 0,
    rang                  INT,
    periode               VARCHAR(32)      NOT NULL,        -- MENSUEL | TRIMESTRIEL
    mois                  INT,
    trimestre             INT,
    annee                 INT              NOT NULL,
    created_at            TIMESTAMP        NOT NULL DEFAULT now(),
    updated_at            TIMESTAMP        NOT NULL DEFAULT now(),
    CONSTRAINT uq_evaluation UNIQUE (commercial_id, annee, mois, trimestre, periode)
);

CREATE INDEX idx_evaluations_commercial ON evaluations (commercial_id);
CREATE INDEX idx_evaluations_annee      ON evaluations (annee DESC);
CREATE INDEX idx_evaluations_classement ON evaluations (annee, periode, taux_realisation DESC);
