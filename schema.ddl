CREATE TABLE cabinet
(
    id BIGINT(20) PRIMARY KEY NOT NULL,
    name VARCHAR(255),
    publicid VARCHAR(255)
);
CREATE TABLE cabinet_contains
(
    cabinet_id BIGINT(20) NOT NULL,
    contains_id BIGINT(20) NOT NULL,
    CONSTRAINT FK_k4eox72s91hi1u5sqsuifsaet FOREIGN KEY (contains_id) REFERENCES consumable (id),
    CONSTRAINT FK_kvhhcbm2vd85agpuxcli30gs FOREIGN KEY (cabinet_id) REFERENCES cabinet (id)
);
CREATE INDEX FK_kvhhcbm2vd85agpuxcli30gs ON cabinet_contains (cabinet_id);
CREATE UNIQUE INDEX UK_k4eox72s91hi1u5sqsuifsaet ON cabinet_contains (contains_id);
CREATE TABLE consumable
(
    id BIGINT(20) PRIMARY KEY NOT NULL,
    code VARCHAR(255),
    color INT(11),
    critical BIT(1) NOT NULL,
    publicid VARCHAR(255),
    quantity_available INT(11) NOT NULL
);
CREATE TABLE printer
(
    id BIGINT(20) PRIMARY KEY NOT NULL,
    name VARCHAR(255),
    publicid VARCHAR(255)
);
CREATE TABLE printer_uses
(
    printer_id BIGINT(20) NOT NULL,
    uses_id BIGINT(20) NOT NULL,
    CONSTRAINT FK_q66g4xn0x0dqexp04nph3a4ie FOREIGN KEY (printer_id) REFERENCES printer (id),
    CONSTRAINT FK_rfw0twn003wit6k5spihd76cy FOREIGN KEY (uses_id) REFERENCES consumable (id)
);
CREATE INDEX FK_q66g4xn0x0dqexp04nph3a4ie ON printer_uses (printer_id);
CREATE UNIQUE INDEX UK_rfw0twn003wit6k5spihd76cy ON printer_uses (uses_id);