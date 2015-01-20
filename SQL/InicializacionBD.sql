----- ALIMENTOS -------------- id --- descripcion --- fecha_cad ---
insert into ALIMENTO values ('1','Esparragos Carretilla','01/01/2016');
insert into ALIMENTO values ('2','Pepinos','02/05/2015');
insert into ALIMENTO values ('3','Lentejas','01/01/2016');
insert into ALIMENTO values ('4','Esparragos Carretilla','01/01/2016');
insert into ALIMENTO values ('5','Esparragos Carretilla','01/01/2017');
insert into ALIMENTO values ('6','Atun Claro Calvo','01/05/2016');
insert into ALIMENTO values ('7','Actimel','02/02/2016');

-- Caducados
insert into ALIMENTO values ('8','Esparragos Carretilla','01/01/2013');
insert into ALIMENTO values ('9','Actimel','02/02/2012');


----- ESTABLECIMIENTOS ------------- id --- nombre --- direccion --- localidad   
insert into ESTABLECIMIENTO values ('1', 'Carrefour', 'C/Blabla, 7', 'Huelva');
insert into ESTABLECIMIENTO values ('2', 'Hipercor', 'C/Blabla2, 1', 'Huelva');
insert into ESTABLECIMIENTO values ('3', 'Casa Hilaria', 'C/Remo, 2', 'Mazagón');


----- VOLUNTARIO ---
insert into VOLUNTARIO values ('1');
insert into VOLUNTARIO values ('2');
insert into VOLUNTARIO values ('3');
insert into VOLUNTARIO values ('4');

----- INSTITUCION --------------- CIF --- nombre ---razon_social --- telefono --- idVol
insert into INSTITUCION values ('A12345678', 'UHU', 'blablarazon', '959999999', '1');
insert into INSTITUCION values ('B12345678', 'Cruz Roja', 'wolololo', '959989999', '2');

----- PERSONA ------------------- DNI --- nombre --- apellido1 --- apellido2 --- edad ---email ---localidad--- telefono --- idvol
insert into PERSONA values ('48949081K', 'Alejandro', 'Trujillo', 'Caballero', '22', 'alejandro@gmail.com', 'Mazagon', '637137623', '3');
insert into PERSONA values ('00000000K', 'Paquito', 'Gonzalez', 'Fernandez', '21', 'eRpaKoShUlo@gmail.com', 'Huelva', '676666366', '4');

--- RECOGE ----------------- Alimento --- voluntario --- Estab --- fechaIN --- FechaOUT --- Entregado
insert into RECOGE values ('1', '1', '1', '13/01/2015', '14/01/2015', 1);
insert into RECOGE values ('2', '1', '1', '13/01/2015', Null, 0);
insert into RECOGE values ('3', '1', '2', '12/01/2015', Null, 0);
insert into RECOGE values ('4', '2', '3', '11/01/2015', Null, 0);
insert into RECOGE values ('5', '3', '2', '10/01/2015', Null, 0);
insert into RECOGE values ('6', '4', '3', '13/01/2015', Null, 0);
insert into RECOGE values ('7', '3', '2', '10/01/2015', Null, 0);
insert into RECOGE values ('8', '2', '3', '9/01/2015', Null, 0);
insert into RECOGE values ('9', '2', '3', '9/01/2015', Null, 0);
