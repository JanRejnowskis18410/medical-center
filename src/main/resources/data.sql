INSERT INTO PERSON (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1998-11-10', 'jkowalski@wp.pl', 'Jan', 'Kowalski', '98111005407');
INSERT INTO PERSON (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1998-11-10', 'anowak@wp.pl', 'Adam', 'Nowak', '98111005401');
INSERT INTO PERSON (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1998-05-10', 'ak@wp.pl', 'Adam', 'Kochanowski', '98050505409');
INSERT INTO PERSON (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1998-05-10', 'aldona@wp.pl', 'Aldona', 'Słowik', '98050591286');
INSERT INTO PERSON (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1973-03-21', 'gosia2@gmail.com', 'Małgorzata', 'Janiak', '73032145682');
INSERT INTO PERSON (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1978-01-30', 'adam.staszewskigmail.com', 'Adam', 'Staszewski', '78013078471');
INSERT INTO PERSON (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1980-04-20', 'barbara.nowak@gmail.com', 'Barbara', 'Nowak', '80042067365');
INSERT INTO PERSON (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1975-09-08', 'elzbieta.gos@gmail.com', 'Elżbieta', 'Gos', '75090823596');
INSERT INTO PERSON (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1960-11-20', 'kamil.gornicki@gmail.com', 'Kamil', 'Górnicki', '60112032634');
INSERT INTO PERSON (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1975-01-02', 'aleksandra.nowicka@gmail.com', 'Aleksandra', 'Nowicka', '75010234299');
INSERT INTO PERSON (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1962-03-15', 'piotr.olewnik@gmail.com', 'Piotr', 'Olewnik', '62031512089');
INSERT INTO PERSON (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1960-08-14', 'tomasz.krol@gmail.com', 'Tomasz', 'Król', '60081438756');
INSERT INTO PERSON (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1967-07-12', 'monika.loch@gmail.com', 'Monika', 'Loch', '67071223645');
INSERT INTO PERSON (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1970-09-16', 'anna.swatek@gmail.com', 'Anna', 'Swatek', '70091645676');


INSERT INTO PATIENT (CITY, COUNTRY, POST_CODE, STREET, STREET_NUMBER, PHONE_NUMBER, ID) VALUES ('Lublin', 'Polska', '20-040', 'Sowińskiego', '18/20', '604456897', 1);
INSERT INTO PATIENT (CITY, COUNTRY, POST_CODE, STREET, STREET_NUMBER, PHONE_NUMBER, ID) VALUES ('Warszawa', 'Polska', '01-172', 'Marszałkowska', '14/89', '503273947', 2);
INSERT INTO PATIENT (CITY, COUNTRY, POST_CODE, STREET, STREET_NUMBER, PHONE_NUMBER, ID) VALUES ('Piaseczno', 'Polska', '20-040', 'Nadarzyńska', '47/12', '726326900', 3);
INSERT INTO PATIENT (CITY, COUNTRY, POST_CODE, STREET, STREET_NUMBER, PHONE_NUMBER, ID) VALUES ('Warszawa', 'Polska', '02-128', 'Puławska', '67/16', '745927345', 4);


INSERT INTO DOCTOR (PWZ, ID) VALUES ('2564897', 5);
INSERT INTO DOCTOR (PWZ, ID) VALUES ('5698742', 6);
INSERT INTO DOCTOR (PWZ, ID) VALUES ('7303243', 7);
INSERT INTO DOCTOR (PWZ, ID) VALUES ('3534578', 8);
INSERT INTO DOCTOR (PWZ, ID) VALUES ('5642562', 9);
INSERT INTO DOCTOR (PWZ, ID) VALUES ('8747824', 10);
INSERT INTO DOCTOR (PWZ, ID) VALUES ('5462456', 11);
INSERT INTO DOCTOR (PWZ, ID) VALUES ('9753423', 12);


insert into SPECIALIZATION (NAME) values ('Ginekolog'); --1
insert into SPECIALIZATION (NAME) values ('Radiolog'); --2
insert into SPECIALIZATION (NAME) values ('Dermatolog'); --3
insert into SPECIALIZATION (NAME) values ('Internista'); --4
insert into SPECIALIZATION (NAME) values ('Pediatra');
insert into SPECIALIZATION (NAME) values ('Okulista');
insert into SPECIALIZATION (NAME) values ('Ortopeda'); --7
insert into SPECIALIZATION (NAME) values ('Endokrynolog');
insert into SPECIALIZATION (NAME) values ('Kardiolog');
insert into SPECIALIZATION (NAME) values ('Laryngolog'); --10
insert into SPECIALIZATION (NAME) values ('Neurolog');
insert into SPECIALIZATION (NAME) values ('Proktolog');
insert into SPECIALIZATION (NAME) values ('Psychiatra'); --13
insert into SPECIALIZATION (NAME) values ('Urolog');
insert into SPECIALIZATION (NAME) values ('Immunolog');
insert into SPECIALIZATION (NAME) values ('Diabetolog'); --16
insert into SPECIALIZATION (NAME) values ('Chirurg ogólny');
insert into SPECIALIZATION (NAME) values ('Chirurg naczyniowy'); --18
insert into SPECIALIZATION (NAME) values ('Gastrolog'); --19


INSERT INTO DOCTOR_SPECIALIZATION (DOCTOR_ID, SPECIALIZATION_ID) VALUES (8,1); --GINEKOLOG
INSERT INTO DOCTOR_SPECIALIZATION (DOCTOR_ID, SPECIALIZATION_ID) VALUES (5,2); --RADIOLOG
INSERT INTO DOCTOR_SPECIALIZATION (DOCTOR_ID, SPECIALIZATION_ID) VALUES (6,3); --DERMATOLOG
INSERT INTO DOCTOR_SPECIALIZATION (DOCTOR_ID, SPECIALIZATION_ID) VALUES (7,4); --INTERNISTA
INSERT INTO DOCTOR_SPECIALIZATION (DOCTOR_ID, SPECIALIZATION_ID) VALUES (9,5); --PEDIATRA
INSERT INTO DOCTOR_SPECIALIZATION (DOCTOR_ID, SPECIALIZATION_ID) VALUES (10,6); --OKULISTA
INSERT INTO DOCTOR_SPECIALIZATION (DOCTOR_ID, SPECIALIZATION_ID) VALUES (11,7); --ORTOPEDA
INSERT INTO DOCTOR_SPECIALIZATION (DOCTOR_ID, SPECIALIZATION_ID) VALUES (12,8); --ENDOKRYNOLOG


INSERT INTO LANGUAGE (DOCTOR_ID, DOCTOR_LANGUAGE) VALUES (5,'PL');
INSERT INTO LANGUAGE (DOCTOR_ID, DOCTOR_LANGUAGE) VALUES (5,'EN');
INSERT INTO LANGUAGE (DOCTOR_ID, DOCTOR_LANGUAGE) VALUES (6,'PL');
INSERT INTO LANGUAGE (DOCTOR_ID, DOCTOR_LANGUAGE) VALUES (6,'EN');
INSERT INTO LANGUAGE (DOCTOR_ID, DOCTOR_LANGUAGE) VALUES (7,'PL');
INSERT INTO LANGUAGE (DOCTOR_ID, DOCTOR_LANGUAGE) VALUES (8,'PL');
INSERT INTO LANGUAGE (DOCTOR_ID, DOCTOR_LANGUAGE) VALUES (9,'PL');
INSERT INTO LANGUAGE (DOCTOR_ID, DOCTOR_LANGUAGE) VALUES (9,'EN');
INSERT INTO LANGUAGE (DOCTOR_ID, DOCTOR_LANGUAGE) VALUES (10,'PL');
INSERT INTO LANGUAGE (DOCTOR_ID, DOCTOR_LANGUAGE) VALUES (11,'PL');
INSERT INTO LANGUAGE (DOCTOR_ID, DOCTOR_LANGUAGE) VALUES (12,'PL');
INSERT INTO LANGUAGE (DOCTOR_ID, DOCTOR_LANGUAGE) VALUES (12,'EN');


INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja ginekologa', false , true, 1);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja ginekologa', false, false, 1);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja radiologa', false , true, 2);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja radiologa', false, false, 2);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja dermatologa', false , true, 3);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja dermatologa', false, false, 3);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja internisty', false , true, 4);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja internisty', false, false, 4);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja pediatry', false , true, 5);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja pediatry', false, false, 5);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja okulisty', false , true, 6);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja okulisty', false, false, 6);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja ortopedy', false , true, 7);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja ortopedy', false, false, 7);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja endokrynologa', false , true, 8);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja endokrynologa', false, false, 8);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja kardiologa', false , true, 9);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja kardiologa', false, false, 9);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja laryngologa', false , true, 10);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja laryngologa', false, false, 10);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja neurologa', false , true, 11);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja neurologa', false, false, 11);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja proktologa', false , true, 12);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja proktologa', false, false, 12);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja psychiatry', false , true, 13);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja psychiatry', false, false, 13);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja urologa', false , true, 14);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja urologa', false, false, 14);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja immunologa', false , true, 15);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja immunologa', false, false, 15);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja diabetologa', false , true, 16);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja diabetologa', false, false, 16);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja chirurga ogólnego', false , true, 17);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja chirurga ogólnego', false, false, 17);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja chirurga naczyniowego', false , true, 18);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja chirurga naczyniowego', false, false, 18);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja gastrologa', false , true, 19);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja gastrologa', false, false, 19);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG piersi', false, true, 2);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG jamy brzusznej',false, true, 19);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Gastroskopia', false , true, 19);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG nadgarstka', false, true, 7);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG stawu biodrowego', false , true, 7);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG stawu barkowego', false , true, 7);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG stawu kolanowego', false , true, 7);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG stawu łokciowego', false , true, 7);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG stawu skokowego', false , true, 7);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- nadgarstka', false , true, 2);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- nadnerczy', false , true, 2);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- podudzia', false , true, 2);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- przedramienia', false , true, 2);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- przysadki mózgowej', false , true, 2);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- ręki', false , true, 2);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- stawu biodrowego', false , true, 2);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- stopy', false , true, 2);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- uda', false , true, 2);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- głowy', false , true, 2);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Soczewki kontaktowe- dobór', false , true, 6);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Komputerowe pole widzenia', false , true, 6);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Badanie EKG', false , true, 9);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Założenie Holtera EKG', false , true, 9);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE) VALUES ('Pobranie krwi i innych materiałów- na czczo', true , true);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE) VALUES ('Pobranie krwi i innych materiałów- nie na czczo', true , true);
INSERT INTO MEDICAL_SERVICE(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE) VALUES ('Cytologia szyjki macicy', true , true);


--ODBYTE WIZYTY
INSERT INTO APPOINTMENT (CONFIRMED, DATE, DESCRIPTION, RECOMMENDATIONS, TYPE, DOCTOR_ID, MEDICAL_SERVICE_ID, PATIENT_ID)
VALUES (TRUE, '2021-11-18T12:45:00', 'Pacjent zgłosił następujące objawy: ból gardła i zatok, suchy kaszel. Zalecana wizyta kontrolna za 2 tygdonie', 'Syrop flugamin 2/dz, ibuprom w przypadku gorączki,','FACILITY', 7, 7, 1);
INSERT INTO REFERRAL (EXPIRY_DATE, ISSUE_DATE, ISSUE_APPOINTMENT_ID, MEDICAL_SERVICE_ID, PATIENT_ID) VALUES ('2021-01-31', '2021-11-18', 1, 7, 1);
INSERT INTO PRESCRIPTION (ACCESS_CODE, BINARY_CODE, CREATION_DATE, EXPIRY_DATE, APPOINTMENT_ID, DOCTOR_ID, PATIENT_ID)
VALUES (25689, '123', '2021-11-18', '2021-12-18', 1, 7, 1);

INSERT INTO APPOINTMENT (CONFIRMED, DATE, DESCRIPTION, RECOMMENDATIONS, TYPE, DOCTOR_ID, MEDICAL_SERVICE_ID, PATIENT_ID)
VALUES (TRUE, '2021-10-18T13:00:00', 'Delitakny trądzik na brodzie oraz czole. Po zakończeniu antybiotyku wizyta kontrolna', 'Antybiotyk 1dz/7dni','FACILITY', 6, 5, 1);
INSERT INTO REFERRAL (EXPIRY_DATE, ISSUE_DATE, ISSUE_APPOINTMENT_ID, MEDICAL_SERVICE_ID, PATIENT_ID) VALUES ('2021-11-30', '2021-10-18', 2, 5, 1);
INSERT INTO PRESCRIPTION (ACCESS_CODE, BINARY_CODE, CREATION_DATE, EXPIRY_DATE, APPOINTMENT_ID, DOCTOR_ID, PATIENT_ID)
VALUES (25689, '123', '2021-10-18', '2021-12-18', 2, 6, 1);

--PULA WIZYT
INSERT INTO APPOINTMENT (CONFIRMED, DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES (FALSE, '2021-12-18T12:00:00', 'FACILITY', 1, 8);
INSERT INTO APPOINTMENT (CONFIRMED, DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES (FALSE, '2021-12-18T12:15:00', 'FACILITY', 1, 8);
INSERT INTO APPOINTMENT (CONFIRMED, DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES (FALSE, '2021-12-18T12:30:00', 'FACILITY', 1, 8);
INSERT INTO APPOINTMENT (CONFIRMED, DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES (FALSE, '2021-12-18T12:45:00', 'FACILITY', 1, 8);

--POTWIERDZONE
INSERT INTO APPOINTMENT (CONFIRMED, DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID, PATIENT_ID) VALUES (TRUE, CURRENT_TIMESTAMP(), 'FACILITY', 7, 7, 1);
INSERT INTO APPOINTMENT (CONFIRMED, DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID, PATIENT_ID) VALUES (TRUE, CURRENT_TIMESTAMP(), 'FACILITY', 7, 7, 2);
INSERT INTO APPOINTMENT (CONFIRMED, DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID, PATIENT_ID) VALUES (TRUE, CURRENT_TIMESTAMP(), 'TELEPHONE', 8, 7, 3);
INSERT INTO APPOINTMENT (CONFIRMED, DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID, PATIENT_ID) VALUES (TRUE, CURRENT_TIMESTAMP(), 'TELEPHONE', 8, 7, 4);





--
-- insert into Referral(expiry_date, issue_date, issue_appointment_id, medical_service_id, patient_id) values ('2021-12-18', '2021-11-18', 2, 7, 1);
-- insert into Referral(expiry_date, issue_date, issue_appointment_id, medical_service_id, patient_id) values ('2021-12-18', '2021-11-18', 3, 8, 1);
--
--
-- insert into check_up values (1, 'Morfologia krwi');
-- insert into check_up values (2, 'Biochemia');
-- insert into check_up values (3, 'Badanie moczu');
--
-- insert into medication values (1, true, 'Gynalgin', 25.5, 1, 'GRAM');
-- insert into medication values (2, true, 'Duomox', 40, 1, 'GRAM');
-- insert into PRESCRIPTION_MEDICATION values ('raz dziennie',  1, 1, 1);
-- insert into PRESCRIPTION_MEDICATION values ('2 razy dziennie, rano i wieczorem x1',  1, 2, 1);
--
-- insert into appointment_check_up values ('Badanie krwi', RAWTOHEX('Test'), 'Wyniki w normie', 1, 1);
-- insert into appointment_check_up values ('Badanie krwi', RAWTOHEX('Test'), 'Wyniki w normie', 1, 3);