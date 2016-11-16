CREATE TABLE resume
(
  uuid CHAR(36) PRIMARY KEY NOT NULL,
  full_name TEXT NOT NULL
);

CREATE TABLE contact
(
  id SERIAL,
  resume_uuid CHAR(36) NOT NULL, REFERENCES resume (uuid)on DELETE CASCADE ,
   type TEXT NOT NULL
  value TEXT NOT NULL
);
CREATE UNIQUE INDEX contact__uuid_type_index ON contact (resume_uuid, type);