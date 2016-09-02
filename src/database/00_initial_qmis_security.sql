CREATE TABLE
    qmis_security.work_systems
    (
        id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
        name VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8
;

CREATE TABLE
    qmis_security.work_business_units
    (
        id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
        name VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
		parent_bu INT(10) UNSIGNED,
		worksystem INT(10) UNSIGNED,
		level INT(10) UNSIGNED,
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8
;

ALTER TABLE
    qmis_security.work_business_units ADD CONSTRAINT work_business_units_fk_1 FOREIGN KEY (parent_bu) REFERENCES
    qmis_security.work_business_units (id)
;

ALTER TABLE
    qmis_security.work_business_units ADD CONSTRAINT work_business_units_fk_2 FOREIGN KEY (worksystem) REFERENCES
    qmis_security.work_systems (id)
;

CREATE TABLE
    qmis_security.privileges
	(
		id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
		name VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
		PRIMARY KEY (id)
	)
	ENGINE=InnoDB DEFAULT CHARSET=utf8
;

CREATE TABLE
    qmis_security.roles
	(
		id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
		name VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
		PRIMARY KEY (id)
	)
	ENGINE=InnoDB DEFAULT CHARSET=utf8
;

CREATE TABLE
    qmis_security.role_privilege_rel
	(
		role_id INT(10) UNSIGNED NOT NULL,
		privilege_id INT(10) UNSIGNED NOT NULL,
		PRIMARY KEY (role_id,privilege_id)
	)
	ENGINE=InnoDB DEFAULT CHARSET=utf8
;

ALTER TABLE
    qmis_security.role_privilege_rel ADD CONSTRAINT role_privilege_rel_fk_1 FOREIGN KEY (role_id) REFERENCES
    qmis_security.roles (id)
;

ALTER TABLE
    qmis_security.role_privilege_rel ADD CONSTRAINT role_privilege_rel_fk_2 FOREIGN KEY (privilege_id) REFERENCES
    qmis_security.privileges (id)
;

CREATE TABLE
    qmis_security.positions
	(
		id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
		name VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
		bu INT(10) UNSIGNED NOT NULL,
		PRIMARY KEY (id)
	)
	ENGINE=InnoDB DEFAULT CHARSET=utf8
;

ALTER TABLE
    qmis_security.positions ADD CONSTRAINT positions_fk_1 FOREIGN KEY (bu) REFERENCES
    qmis_security.work_business_units (id)
;

CREATE TABLE
    qmis_security.role_position_rel
	(
		role_id INT(10) UNSIGNED NOT NULL,
		position_id INT(10) UNSIGNED NOT NULL,
		PRIMARY KEY (role_id,position_id)
	)
	ENGINE=InnoDB DEFAULT CHARSET=utf8
;

ALTER TABLE
    qmis_security.role_position_rel ADD CONSTRAINT role_position_rel_fk_1 FOREIGN KEY (role_id) REFERENCES
    qmis_security.roles (id)
;

ALTER TABLE
    qmis_security.role_position_rel ADD CONSTRAINT role_position_rel_fk_2 FOREIGN KEY (position_id) REFERENCES
    qmis_security.positions (id)
;

CREATE TABLE
	qmis_security.users
	(
		id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
		password VARCHAR(2000) DEFAULT '' NOT NULL,
		name VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
		nickname VARCHAR(80) DEFAULT 'UNDEFINED' NOT NULL,
		cert VARCHAR(80) DEFAULT '' NOT NULL,
		position INT(10) UNSIGNED NOT NULL,
		PRIMARY KEY (id)
	)
    ENGINE=InnoDB DEFAULT CHARSET=utf8
;

ALTER TABLE
	qmis_security.users ADD CONSTRAINT users_fk_1 FOREIGN KEY (position) REFERENCES
	qmis_security.positions (id)
;