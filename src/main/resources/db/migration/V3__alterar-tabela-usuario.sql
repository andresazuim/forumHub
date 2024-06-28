ALTER TABLE usuarios ADD curso_id BIGINT;
ALTER TABLE usuarios ADD FOREIGN KEY (curso_id) REFERENCES cursos(id);
