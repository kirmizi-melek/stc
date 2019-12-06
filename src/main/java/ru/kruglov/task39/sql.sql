CREATE TABLE task39."Documents"
(
    "Content" character varying(100) NOT NULL,
    "Id" bigint NOT NULL,
    "StatusId" bigint,
    "AuthorId" bigint,
    "IsDeleted" boolean NOT NULL,
    PRIMARY KEY ("Id"),
    CONSTRAINT "Document_Id" UNIQUE ("Id")

)
WITH (
    OIDS = FALSE
);

ALTER TABLE task39."Documents"
    OWNER to postgres;

####

CREATE TABLE task39."Statuses"
(
    "Id" bigint NOT NULL,
    "Name" character varying(100) NOT NULL,
    PRIMARY KEY ("Id"),
    CONSTRAINT "Status_Id" UNIQUE ("Id")
)
WITH (
    OIDS = FALSE
);

ALTER TABLE task39."Statuses"
    OWNER to postgres;
