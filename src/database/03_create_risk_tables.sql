CREATE TABLE
    qmis_base.risk_base
    (
        id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,

        task_id INT(10) UNSIGNED NOT NULL,
        bu INT(10) UNSIGNED NOT NULL,
        type INT(10) UNSIGNED NOT NULL,
        category INT(10) UNSIGNED NOT NULL,

        name VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
        rootcause VARCHAR(2000) DEFAULT 'UNDEFINED' NOT NULL,
        consequence VARCHAR(2000) DEFAULT 'UNDEFINED' NOT NULL,

        impactlevel INT(10) UNSIGNED NOT NULL,
        severitylevel INT(10) UNSIGNED NOT NULL,
        probabilitylevel INT(10) UNSIGNED NOT NULL,
        risklevel INT(10) UNSIGNED NOT NULL,

        created_time DATETIME,
        created_by VARCHAR(80),
        updated_time DATETIME,
        updated_by VARCHAR(80),
        last_ip_address VARCHAR(128),

        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8
;

ALTER TABLE
    qmis_base.risk_base ADD CONSTRAINT risk_base_fk_1 FOREIGN KEY (bu) REFERENCES
    qmis_base.work_business_units (id)
;

ALTER TABLE
    qmis_base.risk_base ADD CONSTRAINT risk_base_fk_2 FOREIGN KEY (task_id) REFERENCES
    qmis_base.task_base (id)
;

CREATE TABLE
    qmis_base.risk_types
    (
        id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
        name VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
        created_time DATETIME,
        created_by VARCHAR(80),
        updated_time DATETIME,
        updated_by VARCHAR(80),
        last_ip_address VARCHAR(128),
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8
;

ALTER TABLE
    qmis_base.risk_base ADD CONSTRAINT risk_base_fk_3 FOREIGN KEY (type) REFERENCES
    qmis_base.risk_types (id)
;

CREATE TABLE
    qmis_base.risk_impact_lv
    (
        id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
        name VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
        created_time DATETIME,
        created_by VARCHAR(80),
        updated_time DATETIME,
        updated_by VARCHAR(80),
        last_ip_address VARCHAR(128),
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8
;

ALTER TABLE
    qmis_base.risk_base ADD CONSTRAINT risk_base_fk_4 FOREIGN KEY (impactlevel) REFERENCES
    qmis_base.risk_impact_lv (id)
;

CREATE TABLE
    qmis_base.risk_severity_lv
    (
        id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
        name VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
        created_time DATETIME,
        created_by VARCHAR(80),
        updated_time DATETIME,
        updated_by VARCHAR(80),
        last_ip_address VARCHAR(128),
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8
;

ALTER TABLE
    qmis_base.risk_base ADD CONSTRAINT risk_base_fk_5 FOREIGN KEY (severitylevel) REFERENCES
    qmis_base.risk_severity_lv (id)
;

CREATE TABLE
    qmis_base.risk_categories
    (
        id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
        name VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
        parent INT(10) UNSIGNED NOT NULL,
        level VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
        code VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
        is_temporary VARCHAR(80) DEFAULT 'FALSE' NOT NULL,
        created_time DATETIME,
        created_by VARCHAR(80),
        updated_time DATETIME,
        updated_by VARCHAR(80),
        last_ip_address VARCHAR(128),
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8
;

ALTER TABLE
    qmis_base.risk_base ADD CONSTRAINT risk_base_fk_6 FOREIGN KEY (category) REFERENCES
    qmis_base.risk_categories (id)
;

CREATE TABLE
    qmis_base.risk_probability_lv
    (
        id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
        name VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
        created_time DATETIME,
        created_by VARCHAR(80),
        updated_time DATETIME,
        updated_by VARCHAR(80),
        last_ip_address VARCHAR(128),
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8
;

ALTER TABLE
    qmis_base.risk_base ADD CONSTRAINT risk_base_fk_7 FOREIGN KEY (probabilitylevel) REFERENCES
    qmis_base.risk_probability_lv (id)
;

CREATE TABLE
    qmis_base.risk_lv
    (
        id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
        name VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
        created_time DATETIME,
        created_by VARCHAR(80),
        updated_time DATETIME,
        updated_by VARCHAR(80),
        last_ip_address VARCHAR(128),
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8
;

ALTER TABLE
    qmis_base.risk_base ADD CONSTRAINT risk_base_fk_8 FOREIGN KEY (risklevel) REFERENCES
    qmis_base.risk_lv (id)
;

CREATE TABLE
    qmis_base.risk_ctrl_actions
    (
        id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
        user_id INT(10) UNSIGNED NOT NULL,
        task_phase_id INT(10) UNSIGNED NOT NULL,

        action VARCHAR(2000) DEFAULT 'UNDEFINED' NOT NULL,

        is_completed VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
        result VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
        completion_time DATETIME,

        risk_base_id INT(10) UNSIGNED NOT NULL,

        created_time DATETIME,
        created_by VARCHAR(80),
        updated_time DATETIME,
        updated_by VARCHAR(80),
        last_ip_address VARCHAR(128),

        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8
;

ALTER TABLE
    qmis_base.risk_ctrl_actions ADD CONSTRAINT risk_ctrl_actions_fk_1 FOREIGN KEY (task_phase_id) REFERENCES
    qmis_base.task_phases (id)
;

ALTER TABLE
    qmis_base.risk_ctrl_actions ADD CONSTRAINT risk_ctrl_actions_fk_2 FOREIGN KEY (user_id) REFERENCES
    qmis_base.users (id)
;

ALTER TABLE
    qmis_base.risk_ctrl_actions ADD CONSTRAINT risk_ctrl_actions_fk_3 FOREIGN KEY (risk_base_id) REFERENCES
    qmis_base.risk_base (id)
;

CREATE TABLE
    qmis_base.risk_check_actions
    (
        id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
        user_id INT(10) UNSIGNED NOT NULL,
        task_phase_id INT(10) UNSIGNED NOT NULL,

        action VARCHAR(2000) DEFAULT 'UNDEFINED' NOT NULL,

        is_completed VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
        result VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
        completion_time DATETIME,

        risk_base_id INT(10) UNSIGNED NOT NULL,

        created_time DATETIME,
        created_by VARCHAR(80),
        updated_time DATETIME,
        updated_by VARCHAR(80),
        last_ip_address VARCHAR(128),

        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8
;

ALTER TABLE
    qmis_base.risk_ctrl_actions ADD CONSTRAINT risk_check_actions_fk_1 FOREIGN KEY (task_phase_id) REFERENCES
    qmis_base.task_phases (id)
;

ALTER TABLE
    qmis_base.risk_ctrl_actions ADD CONSTRAINT risk_check_actions_fk_2 FOREIGN KEY (user_id) REFERENCES
    qmis_base.users (id)
;

ALTER TABLE
    qmis_base.risk_ctrl_actions ADD CONSTRAINT risk_check_actions_fk_3 FOREIGN KEY (risk_base_id) REFERENCES
    qmis_base.risk_base (id)
;
