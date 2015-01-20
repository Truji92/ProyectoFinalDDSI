create or replace trigger persona_o_institucion
	before insert on PERSONA
	for each row
	DECLARE
		idVoluntario_erroneo EXCEPTION;
		cantidad number;
	BEGIN
		SELECT count(*) INTO cantidad
		FROM INSTITUCION I
		WHERE I.idVoluntario = :new.idVoluntario;
		IF cantidad <> 0 THEN
			RAISE idVoluntario_erroneo;
		END IF;	
	END
;
