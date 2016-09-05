CREATE TABLE
    qmis_base.incident_types
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
    qmis_base.incident_lv
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
    qmis_base.incident_diagnosis_reports
    (
        id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
        name VARCHAR(2000) DEFAULT 'UNDEFINED' NOT NULL,
        
        appearance TEXT,
        investigation TEXT,
        mechanism_analysis TEXT,
        actions TEXT,
        
        conclusion TEXT,
        
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
    qmis_base.incident_close_t_reports
    (
        id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
        name VARCHAR(2000) DEFAULT 'UNDEFINED' NOT NULL,
        appearance TEXT,
        
        investigation TEXT,
        mechanism_analysis TEXT,
        actions TEXT,
        inference TEXT,
        
        recap TEXT,
        conclusion TEXT,
        
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
    qmis_base.incident_close_m_reports
    (
        id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
        name VARCHAR(2000) DEFAULT 'UNDEFINED' NOT NULL,
        process_overview TEXT,
        
        responsibilities TEXT,
        actions TEXT,
        treatments TEXT,
        improvements TEXT,
        
        recap TEXT,
        conclusion TEXT,
        
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
    qmis_base.incident_base
    (
        id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
        
        task_id INT(10) UNSIGNED NOT NULL,
        bu INT(10) UNSIGNED NOT NULL,
        
        name VARCHAR(2000) DEFAULT 'UNDEFINED' NOT NULL,
        type VARCHAR(2000) DEFAULT 'UNDEFINED' NOT NULL,
        
        type_id INT(10) UNSIGNED NOT NULL,
        lv_id INT(10) UNSIGNED NOT NULL,
        
        open_time DATETIME,
        overview TEXT,
        
        close_time DATETIME,
        close_state VARCHAR(2000) DEFAULT 'UNDEFINED' NOT NULL,
        
        diagnosis_report_id INT(10) UNSIGNED DEFAULT '0' NOT NULL,
        close_t_report_id INT(10) UNSIGNED DEFAULT '0' NOT NULL,
        close_m_report_id INT(10) UNSIGNED DEFAULT '0' NOT NULL,
        
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
    qmis_base.incident_base ADD CONSTRAINT incident_base_fk_1 FOREIGN KEY (bu) REFERENCES
    qmis_security.work_business_units (id)
;

ALTER TABLE
    qmis_base.incident_base ADD CONSTRAINT incident_base_fk_2 FOREIGN KEY (task_id) REFERENCES
    qmis_base.task_base (id)
;

ALTER TABLE
    qmis_base.incident_base ADD CONSTRAINT incident_base_fk_3 FOREIGN KEY (type_id) REFERENCES
    qmis_base.incident_types (id)
;

ALTER TABLE
    qmis_base.incident_base ADD CONSTRAINT incident_base_fk_4 FOREIGN KEY (lv_id) REFERENCES
    qmis_base.incident_lv (id)
;

ALTER TABLE
    qmis_base.incident_base ADD CONSTRAINT incident_base_fk_5 FOREIGN KEY (diagnosis_report_id) REFERENCES
    qmis_base.incident_diagnosis_reports (id)
;

ALTER TABLE
    qmis_base.incident_base ADD CONSTRAINT incident_base_fk_6 FOREIGN KEY (close_t_report_id) REFERENCES
    qmis_base.incident_close_t_reports (id)
;

ALTER TABLE
    qmis_base.incident_base ADD CONSTRAINT incident_base_fk_7 FOREIGN KEY (close_m_report_id) REFERENCES
    qmis_base.incident_close_m_reports (id)
;