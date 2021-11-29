INSERT INTO PERSON VALUES (1, '1998-11-10', 'jkowalski@wp.pl', 'Jan', 'Kowalski', '98111005406');
INSERT INTO PERSON VALUES (2, '1998-11-10', 'anowak@wp.pl', 'Adam', 'Nowak', '98111005407');
INSERT INTO PERSON VALUES (3, '1998-05-10', 'ak@wp.pl', 'Adam', 'Kochanowski', '98050505406');
INSERT INTO PERSON VALUES (4, '1973-03-21', 'gosia2@gmail.com', 'Małgorzata', 'Janiak', '73032145689');

INSERT INTO PATIENT VALUES ('Lublin', 'Polska', '20-040', 'Sowińskiego', '18/20', '604456897', 1);

INSERT INTO DOCTOR VALUES ('1234567', 2);
INSERT INTO DOCTOR VALUES ('2564897', 3);
INSERT INTO DOCTOR VALUES ('5698742', 4);

insert into Person(birth_date, email, first_name, last_name, pesel) values ('1990-01-01', 'kowalski@gmail.com', 'Jan', 'Kowalski', '901232123');
insert into Person(birth_date, email, first_name, last_name, pesel) values ('1999-01-01', 'tomasz@test.pl', 'Tomasz', 'Testowy', '385474234');
insert into Patient values ('Warszawa', 'Polska', '05-207', 'Testowa', '88', '+48111222333', 1);
insert into Doctor values ('3563432', 2);
--
-- insert into Specialization(name) values ('test');
-- insert into Specialization(name) values ('Radiolog');
-- insert into Specialization(name) values ('Dermatolog');
--
-- insert into Medical_Service(name, done_by_medical_staff, facility_service, specialization_id) values ('test', false, true, 1);
-- INSERT INTO MEDICAL_SERVICE(name, done_by_medical_staff, facility_service, specialization_id) values ('Badanie USG tarczycy', false, true, 2);
-- INSERT INTO MEDICAL_SERVICE(name, done_by_medical_staff, facility_service, specialization_id) values ('Badanie USG jamy brzusznej', false, true, 2);
-- INSERT INTO MEDICAL_SERVICE(name, done_by_medical_staff, facility_service, specialization_id) values ('Badanie jajników', false, true, 2);
-- INSERT INTO MEDICAL_SERVICE(name, done_by_medical_staff, facility_service, specialization_id) values ('Badanie RTG palca', false, true, 2);
-- INSERT INTO MEDICAL_SERVICE(name, done_by_medical_staff, facility_service, specialization_id) values ('Konsultacja dermatologa', false, false, 3);
-- INSERT INTO MEDICAL_SERVICE(name, done_by_medical_staff, facility_service, specialization_id) values ('Konsultacja internisty', false, true, 1);
-- INSERT INTO MEDICAL_SERVICE(name, done_by_medical_staff, facility_service, specialization_id) values ('Badanie krwi', true, true, 1);
--
-- insert into Appointment(confirmed, date, description, recommendations, type, medical_service_id) values (true, '2021-11-18T12:00:00', 'test', 'test', 'FACILITY', 2);
-- insert into Appointment(confirmed, date, description, recommendations, type, medical_service_id) values (false, '2021-11-18T12:00:00', 'test', 'test', 'FACILITY', 2);
-- insert into Appointment(confirmed, date, description, recommendations, type, doctor_id, medical_service_id) values (false, '2021-11-18T12:00:00', '', '', 'TELEPHONE', 2,  6);
-- insert into Appointment(confirmed, date, description, recommendations, type, doctor_id, medical_service_id) values (false, '2021-11-18T12:00:00', '', '', 'FACILITY', 2,  5);
-- insert into Appointment(confirmed, date, description, recommendations, type, doctor_id, medical_service_id) values (false, '2021-11-28T12:00:00', '', '', 'TELEPHONE', 4);
--
-- insert into Referral(expiry_date, issue_date, issue_appointment_id, medical_service_id, patient_id) values ('2021-12-18', '2021-11-18', 1, 1, 1);
-- insert into Referral(expiry_date, issue_date, issue_appointment_id, medical_service_id, patient_id) values ('2021-12-18', '2021-11-18', 2, 7, 1);
-- insert into Referral(expiry_date, issue_date, issue_appointment_id, medical_service_id, patient_id) values ('2021-12-18', '2021-11-18', 3, 8, 1);
--
--
-- insert into doctor_specialization (doctor_id, specialization_id) values (2,2);
-- insert into check_up values (1, 'Morfologia krwi');
-- insert into check_up values (2, 'Biochemia');
-- insert into check_up values (3, 'Badanie moczu');
--
-- insert into prescription (ACCESS_CODE, BINARY_CODE , CREATION_DATE , EXPIRY_DATE , APPOINTMENT_ID , DOCTOR_ID , PATIENT_ID ) values (25689, RAWTOHEX('Test'), '2021-11-18', '2021-12-18', 1, 2, 1);
--
-- insert into medication values (1, true, 'Gynalgin', 25.5, 1, 'GRAM');
-- insert into medication values (2, true, 'Duomox', 40, 1, 'GRAM');
-- insert into PRESCRIPTION_MEDICATION values ('raz dziennie',  1, 1, 1);
-- insert into PRESCRIPTION_MEDICATION values ('2 razy dziennie, rano i wieczorem x1',  1, 2, 1);
--
-- insert into appointment_check_up values ('Badanie krwi', RAWTOHEX('Test'), 'Wyniki w normie', 1, 1);
-- insert into appointment_check_up values ('Badanie krwi', RAWTOHEX('Test'), 'Wyniki w normie', 1, 3);