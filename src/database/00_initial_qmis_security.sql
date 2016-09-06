CREATE TABLE
    qmis_base.work_systems
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
    qmis_base.work_business_units
    (
        id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
        name VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
        parent_bu INT(10) UNSIGNED,
        worksystem INT(10) UNSIGNED,
        level INT(10) UNSIGNED,
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
    qmis_base.work_business_units ADD CONSTRAINT work_business_units_fk_1 FOREIGN KEY (parent_bu) REFERENCES
    qmis_base.work_business_units (id)
;

ALTER TABLE
    qmis_base.work_business_units ADD CONSTRAINT work_business_units_fk_2 FOREIGN KEY (worksystem) REFERENCES
    qmis_base.work_systems (id)
;

CREATE TABLE
    qmis_base.privileges
    (
        id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
        name VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
        resource_type VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
        resource_path VARCHAR(2000),
        p_status VARCHAR(80) DEFAULT 'ACT' NOT NULL,
        parent_id INT(10) UNSIGNED NOT NULL,
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
    qmis_base.privileges ADD CONSTRAINT privileges_fk_1 FOREIGN KEY (parent_id) REFERENCES
    qmis_base.privileges (id)
;

CREATE TABLE
    qmis_base.roles
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
    qmis_base.role_privilege_rel
    (
        role_id INT(10) UNSIGNED NOT NULL,
        privilege_id INT(10) UNSIGNED NOT NULL,
        created_time DATETIME,
        created_by VARCHAR(80),
        updated_time DATETIME,
        updated_by VARCHAR(80),
        last_ip_address VARCHAR(128),
        PRIMARY KEY (role_id,privilege_id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8
;

ALTER TABLE
    qmis_base.role_privilege_rel ADD CONSTRAINT role_privilege_rel_fk_1 FOREIGN KEY (role_id) REFERENCES
    qmis_base.roles (id)
;

ALTER TABLE
    qmis_base.role_privilege_rel ADD CONSTRAINT role_privilege_rel_fk_2 FOREIGN KEY (privilege_id) REFERENCES
    qmis_base.privileges (id)
;

CREATE TABLE
    qmis_base.positions
    (
        id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
        name VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
        bu INT(10) UNSIGNED NOT NULL,
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
    qmis_base.positions ADD CONSTRAINT positions_fk_1 FOREIGN KEY (bu) REFERENCES
    qmis_base.work_business_units (id)
;

CREATE TABLE
    qmis_base.role_position_rel
    (
        role_id INT(10) UNSIGNED NOT NULL,
        position_id INT(10) UNSIGNED NOT NULL,
        created_time DATETIME,
        created_by VARCHAR(80),
        updated_time DATETIME,
        updated_by VARCHAR(80),
        last_ip_address VARCHAR(128),
        PRIMARY KEY (role_id,position_id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8
;

ALTER TABLE
    qmis_base.role_position_rel ADD CONSTRAINT role_position_rel_fk_1 FOREIGN KEY (role_id) REFERENCES
    qmis_base.roles (id)
;

ALTER TABLE
    qmis_base.role_position_rel ADD CONSTRAINT role_position_rel_fk_2 FOREIGN KEY (position_id) REFERENCES
    qmis_base.positions (id)
;

CREATE TABLE
    qmis_base.users
    (
        id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
        password VARCHAR(2000) DEFAULT '' NOT NULL,
        name VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
        nickname VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
        cert VARCHAR(80) DEFAULT '' NOT NULL,
        position INT(10) UNSIGNED NOT NULL,
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
    qmis_base.users ADD CONSTRAINT users_fk_1 FOREIGN KEY (position) REFERENCES
    qmis_base.positions (id)
;
