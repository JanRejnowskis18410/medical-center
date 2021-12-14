--pacjenci
INSERT INTO person (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1998-11-10', 'jkowalski@wp.pl', 'Jan', 'Kowalski', '98111005407');
INSERT INTO person (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1998-11-10', 'anowak@wp.pl', 'Adam', 'Nowak', '98111005401');
INSERT INTO person (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1998-05-10', 'ak@wp.pl', 'Adam', 'Kochanowski', '98050505409');
INSERT INTO person (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1998-05-10', 'aldona@wp.pl', 'Aldona', 'Słowik', '98050591286');
--lekarze
INSERT INTO person (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1973-03-21', 'gosia2@gmail.com', 'Małgorzata', 'Janiak', '73032145682');
INSERT INTO person (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1978-01-30', 'adam.staszewskigmail.com', 'Adam', 'Staszewski', '78013078471');
INSERT INTO person (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1980-04-20', 'barbara.nowak@gmail.com', 'Barbara', 'Nowak', '80042067365');
INSERT INTO person (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1975-09-08', 'elzbieta.gos@gmail.com', 'Elżbieta', 'Gos', '75090823596');
INSERT INTO person (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1960-11-20', 'kamil.gornicki@gmail.com', 'Kamil', 'Górnicki', '60112032634');
INSERT INTO person (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1975-01-02', 'aleksandra.nowicka@gmail.com', 'Aleksandra', 'Nowicka', '75010234299');
INSERT INTO person (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1962-03-15', 'piotr.olewnik@gmail.com', 'Piotr', 'Olewnik', '62031512089');
INSERT INTO person (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1960-08-14', 'tomasz.krol@gmail.com', 'Tomasz', 'Król', '60081438756');
INSERT INTO person (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1967-07-12', 'monika.loch@gmail.com', 'Monika', 'Loch', '67071223645');
INSERT INTO person (BIRTH_DATE, EMAIL, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1970-09-16', 'anna.swatek@gmail.com', 'Anna', 'Swatek', '70091645676');


INSERT INTO patient (CITY, COUNTRY, POST_CODE, STREET, STREET_NUMBER, PHONE_NUMBER, ID) VALUES ('Lublin', 'Polska', '20-040', 'Sowińskiego', '18/20', '604456897', 1);
INSERT INTO patient (CITY, COUNTRY, POST_CODE, STREET, STREET_NUMBER, PHONE_NUMBER, ID) VALUES ('Warszawa', 'Polska', '01-172', 'Marszałkowska', '14/89', '503273947', 2);
INSERT INTO patient (CITY, COUNTRY, POST_CODE, STREET, STREET_NUMBER, PHONE_NUMBER, ID) VALUES ('Piaseczno', 'Polska', '20-040', 'Nadarzyńska', '47/12', '726326900', 3);
INSERT INTO patient (CITY, COUNTRY, POST_CODE, STREET, STREET_NUMBER, PHONE_NUMBER, ID) VALUES ('Warszawa', 'Polska', '02-128', 'Puławska', '67/16', '745927345', 4);


INSERT INTO doctor (PWZ, ID) VALUES ('2564897', 5);
INSERT INTO doctor (PWZ, ID) VALUES ('5698742', 6);
INSERT INTO doctor (PWZ, ID) VALUES ('7303243', 7);
INSERT INTO doctor (PWZ, ID) VALUES ('3534578', 8);
INSERT INTO doctor (PWZ, ID) VALUES ('5642562', 9);
INSERT INTO doctor (PWZ, ID) VALUES ('8747824', 10);
INSERT INTO doctor (PWZ, ID) VALUES ('5462456', 11);
INSERT INTO doctor (PWZ, ID) VALUES ('9753423', 12);


insert into specialization (NAME) values ('Ginekolog'); --1
insert into specialization (NAME) values ('Radiolog'); --2
insert into specialization (NAME) values ('Dermatolog'); --3
insert into specialization (NAME) values ('Internista'); --4
insert into specialization (NAME) values ('Pediatra'); --5
insert into specialization (NAME) values ('Okulista'); --6
insert into specialization (NAME) values ('Ortopeda'); --7
insert into specialization (NAME) values ('Endokrynolog'); --8
insert into specialization (NAME) values ('Kardiolog'); --9
insert into specialization (NAME) values ('Laryngolog'); --10
insert into specialization (NAME) values ('Neurolog'); --11
insert into specialization (NAME) values ('Psychiatra'); --12
insert into specialization (NAME) values ('Urolog'); --13
insert into specialization (NAME) values ('Chirurg'); --14
insert into specialization (NAME) values ('Gastrolog'); --15


INSERT INTO doctor_specialization (DOCTOR_ID, SPECIALIZATION_ID) VALUES (8,1); --GINEKOLOG
INSERT INTO doctor_specialization (DOCTOR_ID, SPECIALIZATION_ID) VALUES (5,2); --RADIOLOG
INSERT INTO doctor_specialization (DOCTOR_ID, SPECIALIZATION_ID) VALUES (6,3); --DERMATOLOG
INSERT INTO doctor_specialization (DOCTOR_ID, SPECIALIZATION_ID) VALUES (7,4); --INTERNISTA
INSERT INTO doctor_specialization (DOCTOR_ID, SPECIALIZATION_ID) VALUES (9,5); --PEDIATRA
INSERT INTO doctor_specialization (DOCTOR_ID, SPECIALIZATION_ID) VALUES (10,6); --OKULISTA
INSERT INTO doctor_specialization (DOCTOR_ID, SPECIALIZATION_ID) VALUES (11,7); --ORTOPEDA
INSERT INTO doctor_specialization (DOCTOR_ID, SPECIALIZATION_ID) VALUES (12,8); --ENDOKRYNOLOG


INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (5,'PL');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (5,'EN');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (6,'PL');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (6,'EN');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (7,'PL');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (8,'PL');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (9,'PL');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (9,'EN');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (10,'PL');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (11,'PL');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (12,'PL');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (12,'EN');


INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja ginekologa', false , true, 1); --1
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja ginekologa', false, false, 1);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja radiologa', false , true, 2);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja radiologa', false, false, 2); --4
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja dermatologa', false , true, 3);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja dermatologa', false, false, 3); --6
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja internisty', false , true, 4);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja internisty', false, false, 4); --8
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja pediatry', false , true, 5);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja pediatry', false, false, 5); --10
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja okulisty', false , true, 6);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja okulisty', false, false, 6); --12
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja ortopedy', false , true, 7);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja ortopedy', false, false, 7); --14
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja endokrynologa', false , true, 8);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja endokrynologa', false, false, 8); --16
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja kardiologa', false , true, 9);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja kardiologa', false, false, 9);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja laryngologa', false , true, 10);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja laryngologa', false, false, 10);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja neurologa', false , true, 11);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja neurologa', false, false, 11);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja psychiatry', false , true, 12);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja psychiatry', false, false, 12);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja urologa', false , true, 13);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja urologa', false, false, 13);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja chirurga', false , true, 14);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja chirurga', false, false, 14);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja gastrologa', false , true, 15);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja gastrologa', false, false, 15);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG piersi', false, true, 2);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG jamy brzusznej',false, true, 1);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Gastroskopia', false , true, 15);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG nadgarstka', false, true, 7);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG stawu biodrowego', false , true, 7);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG stawu barkowego', false , true, 7);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG stawu kolanowego', false , true, 7);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG stawu łokciowego', false , true, 7);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG stawu skokowego', false , true, 7);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- nadgarstka', false , true, 2);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- nadnerczy', false , true, 2);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- podudzia', false , true, 2);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- przedramienia', false , true, 2);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- przysadki mózgowej', false , true, 2);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- ręki', false , true, 2);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- stawu biodrowego', false , true, 2);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- stopy', false , true, 2);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- uda', false , true, 2);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- głowy', false , true, 2);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Soczewki kontaktowe- dobór', false , true, 6);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Komputerowe pole widzenia', false , true, 6);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Badanie EKG', false , true, 9);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Założenie Holtera EKG', false , true, 9);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE) VALUES ('Pobranie krwi i innych materiałów- na czczo', true , true);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE) VALUES ('Pobranie krwi i innych materiałów- nie na czczo', true , true);
INSERT INTO medical_service(NAME, DONE_BY_MEDICAL_STAFF, FACILITY_SERVICE) VALUES ('Cytologia szyjki macicy', true , true);

INSERT INTO check_up (NAME) VALUES ('Wymaz z gardła');
INSERT INTO check_up (NAME) VALUES ('Posiew ze zmiany trądzikowej- beztlenowo');
INSERT INTO check_up (NAME) VALUES ('Posiew ze zmiany trądzikowej- tlenowo');
INSERT INTO check_up (NAME) VALUES ('Cytologia');
INSERT INTO check_up (NAME) VALUES ('USG jamy brzusznej');
INSERT INTO check_up (NAME) VALUES ('USG piersi');
INSERT INTO check_up (NAME) VALUES ('USG transwaginalne');
INSERT INTO check_up (NAME) VALUES ('Rezonans przysadki mózgowej');
INSERT INTO check_up (NAME) VALUES ('Rezonans czaszki');
INSERT INTO check_up (NAME) VALUES ('Posiew moczu');

--ODBYTE WIZYTY
--Konsultacja ginekologa - Elżbieta Gos, Pacjent id 1
INSERT INTO appointment (STATE, DATE, DESCRIPTION, RECOMMENDATIONS, TYPE, DOCTOR_ID, MEDICAL_SERVICE_ID, PATIENT_ID)
VALUES ('DONE', '2021-11-18T12:45:00', 'Pacjent zgłosił następujące objawy: ból gardła i zatok, suchy kaszel. Zalecana wizyta kontrolna za 2 tygdonie', 'Syrop flugamin 2/dz, ibuprom w przypadku gorączki,','FACILITY', 7, 7, 1);
INSERT INTO referral (EXPIRY_DATE, ISSUE_DATE, ISSUE_appointment_ID, MEDICAL_SERVICE_ID, PATIENT_ID) VALUES ('2022-01-31', '2021-11-18', 1, 7, 1);
INSERT INTO prescription (ACCESS_CODE, CREATION_DATE, EXPIRY_DATE, appointment_ID, DOCTOR_ID, PATIENT_ID)
VALUES (25689, '2021-11-18', '2021-12-18', 1, 7, 1);
INSERT INTO appointment_check_up (doctors_description, result, appointment_id, check_up_id) VALUES ('Badanie w celu wykluczenia zakażenia bakteryjnego', 'Nie wykryto bakterii', 1,1);

--Konsultacja dermatologa, Pacjent id 1
INSERT INTO appointment (STATE, DATE, DESCRIPTION, RECOMMENDATIONS, TYPE, DOCTOR_ID, MEDICAL_SERVICE_ID, PATIENT_ID)
VALUES ('DONE', '2021-10-18T13:00:00', 'Delitakny trądzik na brodzie oraz czole. Po zakończeniu antybiotyku wizyta kontrolna', 'Antybiotyk 1dz/7dni','FACILITY', 6, 5, 1);
INSERT INTO referral (EXPIRY_DATE, ISSUE_DATE, ISSUE_appointment_ID, MEDICAL_SERVICE_ID, PATIENT_ID) VALUES ('2021-12-31', '2021-10-18', 2, 5, 1);
INSERT INTO prescription (ACCESS_CODE, CREATION_DATE, EXPIRY_DATE, appointment_ID, DOCTOR_ID, PATIENT_ID)
VALUES (25689, '2021-10-18', '2021-12-18', 2, 6, 1);
INSERT INTO appointment_check_up (appointment_id, check_up_id) VALUES (2,2);

--Konsultacja dermatologa, Pacjent id 1
INSERT INTO appointment (STATE, DATE, DESCRIPTION, RECOMMENDATIONS, TYPE, DOCTOR_ID, MEDICAL_SERVICE_ID, PATIENT_ID)
VALUES ('DONE', '2021-09-18T13:00:00', 'Wizyta kontrolna z trądzikiem', 'Koniec przyjmowania antybiotyku','FACILITY', 6, 5, 1);
INSERT INTO referral (EXPIRY_DATE, ISSUE_DATE, ISSUE_appointment_ID, MEDICAL_SERVICE_ID, PATIENT_ID) VALUES ('2021-12-18', '2021-12-01', 2, 5, 1);



--PULA WIZYT
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2021-12-18T12:00:00', 'FACILITY', 1, 8);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2021-12-18T12:15:00', 'FACILITY', 1, 8);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2021-12-18T12:30:00', 'FACILITY', 1, 8);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2021-12-18T12:45:00', 'FACILITY', 1, 8);

--POTWIERDZONE
INSERT INTO appointment (STATE, DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID, PATIENT_ID) VALUES ('CONFIRMED', CURRENT_TIMESTAMP(), 'FACILITY', 7, 7, 1);
INSERT INTO appointment (STATE, DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID, PATIENT_ID) VALUES ('CONFIRMED', CURRENT_TIMESTAMP(), 'FACILITY', 7, 7, 2);
INSERT INTO appointment (STATE, DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID, PATIENT_ID) VALUES ('CONFIRMED', CURRENT_TIMESTAMP(), 'TELEPHONE', 8, 7, 3);
INSERT INTO appointment (STATE, DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID, PATIENT_ID) VALUES ('CONFIRMED', CURRENT_TIMESTAMP(), 'TELEPHONE', 8, 7, 4);

--Ginekolog Elzbieta Gos
insert into schedule (Date_from, Date_to, day_of_week, doctor_id, specialization_id) values ('2021-12-06T08:00:00', '2021-12-06T12:00:00', 0, 8,1);
insert into schedule (Date_from, Date_to, day_of_week, doctor_id, specialization_id) values ('2021-12-07T10:00:00', '2021-12-07T14:00:00', 1, 8,1);
insert into schedule (Date_from, Date_to, day_of_week, doctor_id, specialization_id) values ('2021-12-08T08:00:00', '2021-12-08T11:00:00', 2, 8,1);
insert into schedule (Date_from, Date_to, day_of_week, doctor_id, specialization_id) values ('2021-12-08T14:00:00', '2021-12-08T17:00:00', 2, 8,1);
insert into schedule (Date_from, Date_to, day_of_week, doctor_id, specialization_id) values ('2021-12-09T08:00:00', '2021-12-09T17:00:00', 3, 8,1);
insert into schedule (Date_from, Date_to, day_of_week, doctor_id, specialization_id) values ('2021-12-10T13:00:00', '2021-12-10T17:00:00', 4, 8,1);
insert into schedule (Date_from, Date_to, day_of_week, doctor_id, specialization_id) values ('2021-12-11T09:00:00', '2021-12-11T13:00:00', 5, 8,1);


INSERT INTO medication (NAME, UNIT, PAYMENT, QUANTITY) values ('Gynalgin', 'GRAMS', 0.8, 100);

insert into patients_file (name, file, description, type, upload_date, patient_id) values ('zdj1', '123', 'lala', '.png', CURRENT_TIMESTAMP(),1);

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