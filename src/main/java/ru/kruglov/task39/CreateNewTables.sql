CREATE SCHEMA "task39"
    AUTHORIZATION postgres;

CREATE TABLE task39."Documents"
(
    "Id" serial NOT NULL,
    "Content" character varying(100) NOT NULL,
    "StatusId" bigint,
    "AuthorId" bigint,
    "IsDeleted" boolean DEFAULT 'false' NOT NULL,
    PRIMARY KEY ("Id")
);

CREATE TABLE task39."Statuses"
(
    "Id" serial NOT NULL,
    "Name" character varying(100) NOT NULL,
    PRIMARY KEY ("Id")
);

CREATE TABLE task39."UserProfiles" (
    "Id" serial NOT NULL,
    "FirstName" character varying(100) NOT NULL,
    "LastName" character varying(100) NOT NULL,
    "Login" character varying(100) NOT NULL,
    "Password" character varying(100) NOT NULL,
    "IsDeleted" boolean DEFAULT 'false' NOT NULL,
    PRIMARY KEY ("Id")
);

CREATE TABLE task39."Roles"
(
    "Id" serial NOT NULL,
    "Name" character varying(100) NOT NULL,
    PRIMARY KEY ("Id")
);


CREATE TABLE task39."UserProfilesRoles"
(
    "UserProfileId" bigint NOT NULL,
    "RoleId" bigint NOT NULL
);


CREATE TABLE task39."Tasks"
(
    "Id" serial NOT NULL,
    "Title" character varying(100) NOT NULL,
    "Details" character varying(100),
    PRIMARY KEY ("Id")
);

CREATE TABLE task39."DocumentTasks"
(
    "DocumentId" bigint NOT NULL,
    "TaskId" bigint NOT NULL
);

CREATE TABLE task39."Attachments"
(
    "Id" serial NOT NULL,
    "LinkToAttachment" character varying(100),
    "Details" character varying(100),
    PRIMARY KEY ("Id")
);

CREATE TABLE task39."DocumentAttachments"
(
    "DocumentId" bigint NOT NULL,
    "AttachmentId" bigint NOT NULL
);

ALTER TABLE task39."Documents"
    ADD CONSTRAINT "FK_Status" FOREIGN KEY ("StatusId")
    REFERENCES task39."Statuses" ("Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

ALTER TABLE task39."Documents"
    ADD CONSTRAINT "FK_Author" FOREIGN KEY ("AuthorId")
    REFERENCES task39."UserProfiles" ("Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

ALTER TABLE task39."UserProfilesRoles"
    ADD CONSTRAINT "FK_UserProfile" FOREIGN KEY ("UserProfileId")
    REFERENCES task39."UserProfiles" ("Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

ALTER TABLE task39."UserProfilesRoles"
    ADD CONSTRAINT "FK_Role" FOREIGN KEY ("RoleId")
    REFERENCES task39."Roles" ("Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

ALTER TABLE task39."DocumentTasks"
    ADD CONSTRAINT "FK_Document" FOREIGN KEY ("DocumentId")
    REFERENCES task39."Documents" ("Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

ALTER TABLE task39."DocumentTasks"
    ADD CONSTRAINT "FK_Task" FOREIGN KEY ("TaskId")
    REFERENCES task39."Documents" ("Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

ALTER TABLE task39."DocumentAttachments"
    ADD CONSTRAINT "FK_Document" FOREIGN KEY ("DocumentId")
    REFERENCES task39."Documents" ("Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

ALTER TABLE task39."DocumentAttachments"
    ADD CONSTRAINT "FK_Attachment" FOREIGN KEY ("AttachmentId")
    REFERENCES task39."Documents" ("Id") MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;