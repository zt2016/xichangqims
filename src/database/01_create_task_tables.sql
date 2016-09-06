CREATE TABLE
    qmis_base.task_categories
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
    qmis_base.task_base
    (
        id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
        name VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
        category INT(10) UNSIGNED DEFAULT '0' NOT NULL,
        start_time DATETIME,
        end_time DATETIME,
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
    qmis_base.task_phases
    (
        id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
        name VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
        previous INT(10) UNSIGNED,
        worksystem INT(10) UNSIGNED,
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
    qmis_base.task_phases ADD CONSTRAINT task_phase_fk_1 FOREIGN KEY (previous) REFERENCES
    qmis_base.task_phases (id)
;

ALTER TABLE
	qmis_base.task_phases ADD CONSTRAINT task_phase_fk_2 FOREIGN KEY (worksystem) REFERENCES
	qmis_base.work_systems (id)
;

CREATE TABLE
    qmis_base.task_phase_controls
    (
        id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
        worksystem INT(10) UNSIGNED NOT NULL,
        task_id INT(10) UNSIGNED NOT NULL,
        task_phase_id INT(10) UNSIGNED NOT NULL,
        start_time DATETIME,
        end_time DATETIME,
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
    qmis_base.task_phase_controls ADD CONSTRAINT task_phase_ctrl_fk_1 FOREIGN KEY (task_id) REFERENCES
    qmis_base.task_base (id)
;

ALTER TABLE
    qmis_base.task_phase_controls ADD CONSTRAINT task_phase_ctrl_fk_2 FOREIGN KEY (task_phase_id) REFERENCES
    qmis_base.task_phases (id)
;

ALTER TABLE
    qmis_base.task_phase_controls ADD CONSTRAINT task_phase_ctrl_fk_3 FOREIGN KEY (worksystem) REFERENCES
    qmis_base.work_systems (id)
;
