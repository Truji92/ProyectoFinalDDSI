create or replace trigger institucion_o_persona 
	before insert on INSTITUCION
	for each row
	DECLARE
		idVoluntario_erroneo EXCEPTION;
		cantidad number;
	BEGIN
		SELECT count(*) INTO cantidad
		FROM PERSONA p
		WHERE p.idVoluntario = :new.idVoluntario;
		IF cantidad <> 0 THEN
			RAISE idVoluntario_erroneo;
		END IF;	
	END
;

