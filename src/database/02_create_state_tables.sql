CREATE TABLE
    qmis_base.task_baselines
    (
        id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
        reason VARCHAR(2000) DEFAULT 'UNDEFINED' NOT NULL,
        bu INT(10) UNSIGNED,
        current_task INT(10) UNSIGNED,
        baseline_task INT(10) UNSIGNED,
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
	qmis_base.task_baselines ADD CONSTRAINT task_baselines_fk_1 FOREIGN KEY (current_task) REFERENCES
	qmis_base.task_base (id)
;

ALTER TABLE
	qmis_base.task_baselines ADD CONSTRAINT task_baselines_fk_2 FOREIGN KEY (baseline_task) REFERENCES
	qmis_base.task_base (id)
;

ALTER TABLE
	qmis_base.task_baselines ADD CONSTRAINT task_baselines_fk_3 FOREIGN KEY (bu) REFERENCES
	qmis_security.work_business_units (id)
;

CREATE TABLE
    qmis_base.task_state_change_categories
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

CREATE TABLE
    qmis_base.task_state_change_impact_lv
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

CREATE TABLE
    qmis_base.task_state_change_details
    (
        id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
        baseline_id INT(10) UNSIGNED NOT NULL,
        baseline_factor VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
        state_change_category INT(10) UNSIGNED NOT NULL,
        state_change_lv INT(10) UNSIGNED NOT NULL,
        reason VARCHAR(2000) DEFAULT 'UNDEFINED' NOT NULL,
        domain_impact_analysis VARCHAR(2000) DEFAULT 'UNDEFINED' NOT NULL,
        current_task_state VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
        baseline_task_state VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
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
    qmis_base.task_state_change_details ADD CONSTRAINT task_state_change_details_fk_1 FOREIGN KEY (baseline_id) REFERENCES
    qmis_base.task_baselines (id)
;

ALTER TABLE
    qmis_base.task_state_change_details ADD CONSTRAINT task_state_change_details_fk_2 FOREIGN KEY (state_change_category) REFERENCES
    qmis_base.task_state_change_categories (id)
;

ALTER TABLE
    qmis_base.task_state_change_details ADD CONSTRAINT task_state_change_details_fk_3 FOREIGN KEY (state_change_lv) REFERENCES
    qmis_base.task_state_change_impact_lv (id)
;

CREATE TABLE
    qmis_base.task_state_change_actions
    (
        id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
        state_change_details_id INT(10) UNSIGNED NOT NULL,
        action VARCHAR(2000) DEFAULT 'UNDEFINED' NOT NULL,
        domain_impact_analysis VARCHAR(2000) DEFAULT 'UNDEFINED' NOT NULL,
        user_id INT(10) UNSIGNED NOT NULL,
        task_phase_id INT(10) UNSIGNED NOT NULL,
        is_completed VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
        result VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
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
    qmis_base.task_state_change_actions ADD CONSTRAINT task_state_change_actions_fk_1 FOREIGN KEY (state_change_details_id) REFERENCES
    qmis_base.task_state_change_details (id)
;

ALTER TABLE
    qmis_base.task_state_change_actions ADD CONSTRAINT task_state_change_actions_fk_2 FOREIGN KEY (task_phase_id) REFERENCES
    qmis_base.task_phases (id)
;

ALTER TABLE
    qmis_base.task_state_change_actions ADD CONSTRAINT task_state_change_actions_fk_3 FOREIGN KEY (user_id) REFERENCES
    qmis_security.users (id)
;