-- =========================================================
-- Lot 1 : Site, Operation, Commission, ChiffreAffaires
-- + colonnes supplémentaires sur Concessionnaire (uid)
-- =========================================================

CREATE TABLE sites (
    id            BIGSERIAL    PRIMARY KEY,
    libelle       VARCHAR(255) NOT NULL,
    type          INT          NOT NULL DEFAULT 0,
    parent_id     BIGINT       REFERENCES sites (id) ON DELETE SET NULL,
    code          VARCHAR(64)  UNIQUE,
    code_provinov VARCHAR(64),
    status        BOOLEAN      NOT NULL DEFAULT TRUE,
    created_at    TIMESTAMP    NOT NULL DEFAULT now(),
    updated_at    TIMESTAMP    NOT NULL DEFAULT now()
);

CREATE INDEX idx_sites_parent ON sites (parent_id);
CREATE INDEX idx_sites_type   ON sites (type);

-- Lien Terminal → Site (déjà déclaré dans V1 sous forme d'ID seulement, on ajoute la FK ici)
ALTER TABLE terminals
    ADD CONSTRAINT fk_terminals_site FOREIGN KEY (site_id) REFERENCES sites (id) ON DELETE SET NULL;

ALTER TABLE concessionnaire_produit
    ADD CONSTRAINT fk_cp_site FOREIGN KEY (site_id) REFERENCES sites (id) ON DELETE SET NULL;

CREATE TABLE chiffre_affaires (
    id            BIGSERIAL    PRIMARY KEY,
    terminal_id   BIGINT       NOT NULL REFERENCES terminals (id) ON DELETE CASCADE,
    brut          BIGINT       NOT NULL DEFAULT 0,
    paiement      BIGINT       NOT NULL DEFAULT 0,
    annulation    BIGINT       NOT NULL DEFAULT 0,
    remboursement BIGINT       NOT NULL DEFAULT 0,
    ventes        BIGINT       NOT NULL DEFAULT 0,
    balance       BIGINT       NOT NULL DEFAULT 0,
    deposit       BIGINT       NOT NULL DEFAULT 0,
    date          TIMESTAMP    NOT NULL,
    created_at    TIMESTAMP    NOT NULL DEFAULT now(),
    updated_at    TIMESTAMP    NOT NULL DEFAULT now()
);

CREATE INDEX idx_ca_terminal      ON chiffre_affaires (terminal_id);
CREATE INDEX idx_ca_terminal_date ON chiffre_affaires (terminal_id, date DESC);
CREATE INDEX idx_ca_date          ON chiffre_affaires (date DESC);

CREATE TABLE commissions (
    id              BIGSERIAL    PRIMARY KEY,
    code            VARCHAR(64)  UNIQUE,
    terminal_id     BIGINT       NOT NULL REFERENCES terminals (id) ON DELETE CASCADE,
    nombre_terminal INT          NOT NULL DEFAULT 1,
    paye            BOOLEAN      NOT NULL DEFAULT FALSE,
    libelle         VARCHAR(255),
    status          VARCHAR(32)  NOT NULL DEFAULT 'EN_ATTENTE',
    created_at      TIMESTAMP    NOT NULL DEFAULT now(),
    updated_at      TIMESTAMP    NOT NULL DEFAULT now()
);

CREATE INDEX idx_commissions_terminal ON commissions (terminal_id);
CREATE INDEX idx_commissions_status   ON commissions (status);

CREATE TABLE operations (
    id             BIGSERIAL    PRIMARY KEY,
    code           VARCHAR(64),
    libelle        VARCHAR(255),
    reference      VARCHAR(128) UNIQUE,
    montant        BIGINT       NOT NULL DEFAULT 0,
    montant_reel   BIGINT       NOT NULL DEFAULT 0,
    statut         VARCHAR(32)  NOT NULL DEFAULT 'EN_ATTENTE',
    terminal_id    BIGINT       NOT NULL REFERENCES terminals (id) ON DELETE CASCADE,
    guichet        VARCHAR(64),
    date_operation TIMESTAMP    NOT NULL,
    created_at     TIMESTAMP    NOT NULL DEFAULT now(),
    updated_at     TIMESTAMP    NOT NULL DEFAULT now()
);

CREATE INDEX idx_operations_terminal ON operations (terminal_id);
CREATE INDEX idx_operations_statut   ON operations (statut);
CREATE INDEX idx_operations_date     ON operations (date_operation DESC);
