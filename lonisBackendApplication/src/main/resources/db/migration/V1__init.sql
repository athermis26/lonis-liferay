-- =========================================================
-- Schéma initial Lonis Backend (PostgreSQL)
-- Périmètre v1 : Concessionnaire, Produit, Terminal, ConcessionnaireProduit
-- Les autres entités seront ajoutées dans des migrations Vn ultérieures.
-- =========================================================

CREATE TABLE concessionnaires (
    id          BIGSERIAL    PRIMARY KEY,
    uid         VARCHAR(64)  UNIQUE,
    nom         VARCHAR(255) NOT NULL,
    prenoms     VARCHAR(255),
    telephone   VARCHAR(32),
    email       VARCHAR(255),
    created_at  TIMESTAMP    NOT NULL DEFAULT now(),
    updated_at  TIMESTAMP    NOT NULL DEFAULT now()
);

CREATE INDEX idx_concessionnaires_nom ON concessionnaires (nom);

CREATE TABLE produits (
    id          BIGSERIAL    PRIMARY KEY,
    code        VARCHAR(64)  UNIQUE NOT NULL,
    libelle     VARCHAR(255) NOT NULL,
    abreviation VARCHAR(64),
    active      BOOLEAN      NOT NULL DEFAULT TRUE,
    created_at  TIMESTAMP    NOT NULL DEFAULT now(),
    updated_at  TIMESTAMP    NOT NULL DEFAULT now()
);

CREATE INDEX idx_produits_libelle ON produits (libelle);

CREATE TABLE concessionnaire_produit (
    id                   BIGSERIAL    PRIMARY KEY,
    concessionnaire_id   BIGINT       NOT NULL REFERENCES concessionnaires (id) ON DELETE CASCADE,
    produit_id           BIGINT       NOT NULL REFERENCES produits (id)         ON DELETE CASCADE,
    site_id              BIGINT,
    code                 VARCHAR(64)  UNIQUE,
    concessionnaire_code VARCHAR(64),
    active               BOOLEAN      NOT NULL DEFAULT TRUE,
    created_at           TIMESTAMP    NOT NULL DEFAULT now(),
    updated_at           TIMESTAMP    NOT NULL DEFAULT now(),
    CONSTRAINT uq_conc_prod UNIQUE (concessionnaire_id, produit_id)
);

CREATE INDEX idx_cp_concessionnaire ON concessionnaire_produit (concessionnaire_id);
CREATE INDEX idx_cp_produit         ON concessionnaire_produit (produit_id);

CREATE TABLE terminals (
    id                            BIGSERIAL    PRIMARY KEY,
    code_terminal                 VARCHAR(64)  UNIQUE NOT NULL,
    concessionnaire_id            BIGINT       REFERENCES concessionnaires (id) ON DELETE SET NULL,
    concessionnaire_code          VARCHAR(64),
    produit_id                    BIGINT       REFERENCES produits (id)         ON DELETE SET NULL,
    concessionnaire_produit_code  VARCHAR(64),
    site_id                       BIGINT,
    latitude                      DOUBLE PRECISION,
    longitude                     DOUBLE PRECISION,
    adresse                       VARCHAR(512),
    statut_validation             VARCHAR(32)  NOT NULL DEFAULT 'EN_ATTENTE',
    created_at                    TIMESTAMP    NOT NULL DEFAULT now(),
    updated_at                    TIMESTAMP    NOT NULL DEFAULT now()
);

CREATE INDEX idx_terminals_concessionnaire ON terminals (concessionnaire_id);
CREATE INDEX idx_terminals_site            ON terminals (site_id);
CREATE INDEX idx_terminals_statut          ON terminals (statut_validation);
