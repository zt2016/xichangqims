CREATE DATABASE IF NOT EXISTS qmis_base DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
CREATE DATABASE IF NOT EXISTS qmis_archive DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
CREATE DATABASE IF NOT EXISTS qmis_security DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

CREATE USER qmisadmin@localhost IDENTIFIED BY 'Welcome1';
CREATE USER qmisroot@localhost IDENTIFIED BY 'Welcome1';

GRANT ALL PRIVILEGES ON qmis_base.* TO qmisadmin@localhost IDENTIFIED BY 'Welcome1';
GRANT ALL PRIVILEGES ON qmis_archive.* TO qmisadmin@localhost IDENTIFIED BY 'Welcome1';
GRANT ALL PRIVILEGES ON qmis_security.* TO qmisadmin@localhost IDENTIFIED BY 'Welcome1';

GRANT ALL PRIVILEGES ON qmis_base.* TO qmisroot@localhost IDENTIFIED BY 'Welcome1';
GRANT ALL PRIVILEGES ON qmis_archive.* TO qmisroot@localhost IDENTIFIED BY 'Welcome1';
GRANT ALL PRIVILEGES ON qmis_security.* TO qmisroot@localhost IDENTIFIED BY 'Welcome1';
