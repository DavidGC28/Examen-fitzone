-- 1. Tabla General--------------------------------------------------------

CREATE TABLE socios (
id_socio INT PRIMARY KEY,
nombres VARCHAR(50) NOT NULL,
apellidos VARCHAR(50) NOT NULL,
edad INT  NOT NULL,
fecha_registro VARCHAR(10) NOT NULL,
activo BOOLEAN NOT NULL
);

-- 2. DAtos de los socios------------------------------------------------------

INSERT INTO socios (id_socio,nombres,apellidos,edad,fecha_registro,activo)VALUES
(001,'David','Guamanzara Cruz',28,'2026-01-28',TRUE),
(002,'Annie','Gonzalez Rincones',15,'2025-02-08',TRUE),
(003,'Alfredo','Ramirez Ruiz',28,'2025-10-18',FALSE),
(004,'Melanie','Ponce Rincones',21,'2026-01-15',TRUE),
(005,'David','Torres Cruz',17,'2026-05-20',TRUE);

--3. Consultas-----------------------------------------------------

SELECT nombres, apellidos, edad FROM socios WHERE activo = TRUE AND edad > 18;

SELECT * FROM socios WHERE fecha_registro > '2026-02-01';

SELECT * FROM socios ORDER BY edad DESC;


-- 4. Modificacion de tabla con correo

ALTER TABLE socios ADD COLUMN email VARCHAR(100);

UPDATE socios SET email = 'correo@mail.com' WHERE id_socio = 001;



