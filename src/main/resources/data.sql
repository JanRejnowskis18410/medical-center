--lekarze
INSERT INTO person (BIRTH_DATE, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1973-03-21', 'Małgorzata', 'Janiak', '74113042266');
INSERT INTO person (BIRTH_DATE, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1978-01-30', 'Adam', 'Staszewski', '61120148478');
INSERT INTO person (BIRTH_DATE, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1980-04-20', 'Barbara', 'Nowak', '86011641122');
INSERT INTO person (BIRTH_DATE, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1975-09-08', 'Elżbieta', 'Gos', '73121164625');
INSERT INTO person (BIRTH_DATE, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1960-11-20', 'Kamil', 'Górnicki', '60081657173');
INSERT INTO person (BIRTH_DATE, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1975-01-02', 'Aleksandra', 'Nowicka', '73121037189');
INSERT INTO person (BIRTH_DATE, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1962-03-15', 'Piotr', 'Olewnik', '86102027299');
INSERT INTO person (BIRTH_DATE, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1960-08-14', 'Tomasz', 'Król', '90061325893');
INSERT INTO person (BIRTH_DATE, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1967-07-12', 'Monika', 'Loch', '57051495725');
INSERT INTO person (BIRTH_DATE, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1970-09-16', 'Anna', 'Swatek', '70091645676');

--pacjenci
INSERT INTO person (BIRTH_DATE, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1969-01-14', 'Jan', 'Kowalski', '69011471496');
INSERT INTO person (BIRTH_DATE, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1998-11-10', 'Adam', 'Nowak', '98111005401');
INSERT INTO person (BIRTH_DATE, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1998-05-10', 'Adam', 'Kochanowski', '86012028991');
INSERT INTO person (BIRTH_DATE, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1998-05-10', 'Aldona', 'Słowik', '94060431348');
INSERT INTO person (BIRTH_DATE, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1960-04-30', 'Anna', 'Morawska', '60043064267');
INSERT INTO patient (CITY, COUNTRY, POST_CODE, STREET, STREET_NUMBER, PHONE_NUMBER, ID) VALUES ('Lublin', 'Polska', '20-040', 'Sowińskiego', '18/20', '604456897', 11);
INSERT INTO patient (CITY, COUNTRY, POST_CODE, STREET, STREET_NUMBER, PHONE_NUMBER, ID) VALUES ('Warszawa', 'Polska', '01-172', 'Marszałkowska', '14/89', '503273947', 12);
INSERT INTO patient (CITY, COUNTRY, POST_CODE, STREET, STREET_NUMBER, PHONE_NUMBER, ID) VALUES ('Piaseczno', 'Polska', '20-040', 'Nadarzyńska', '47/12', '726326900', 13);
INSERT INTO patient (CITY, COUNTRY, POST_CODE, STREET, STREET_NUMBER, PHONE_NUMBER, ID) VALUES ('Warszawa', 'Polska', '02-128', 'Puławska', '67/16', '745927345', 14);
INSERT INTO patient (CITY, COUNTRY, POST_CODE, STREET, STREET_NUMBER, PHONE_NUMBER, ID) VALUES ('Ryki', 'Polska', '08-500', 'Swatowska', '58', '604568898', 15);


INSERT INTO doctor (PWZ, ID) VALUES ('2564897', 1);
INSERT INTO doctor (PWZ, ID) VALUES ('5698742', 2);
INSERT INTO doctor (PWZ, ID) VALUES ('7303243', 3);
INSERT INTO doctor (PWZ, ID) VALUES ('3534578', 4);
INSERT INTO doctor (PWZ, ID) VALUES ('5642562', 5);
INSERT INTO doctor (PWZ, ID) VALUES ('8747824', 6);
INSERT INTO doctor (PWZ, ID) VALUES ('5462456', 7);
INSERT INTO doctor (PWZ, ID) VALUES ('9753423', 8);


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


INSERT INTO doctor_specialization (DOCTOR_ID, SPECIALIZATION_ID) VALUES (1,1); --GINEKOLOG
INSERT INTO doctor_specialization (DOCTOR_ID, SPECIALIZATION_ID) VALUES (2,2); --RADIOLOG
INSERT INTO doctor_specialization (DOCTOR_ID, SPECIALIZATION_ID) VALUES (3,3); --DERMATOLOG
INSERT INTO doctor_specialization (DOCTOR_ID, SPECIALIZATION_ID) VALUES (4,4); --INTERNISTA
INSERT INTO doctor_specialization (DOCTOR_ID, SPECIALIZATION_ID) VALUES (5,5); --PEDIATRA
INSERT INTO doctor_specialization (DOCTOR_ID, SPECIALIZATION_ID) VALUES (6,6); --OKULISTA
INSERT INTO doctor_specialization (DOCTOR_ID, SPECIALIZATION_ID) VALUES (7,7); --ORTOPEDA
INSERT INTO doctor_specialization (DOCTOR_ID, SPECIALIZATION_ID) VALUES (8,8); --ENDOKRYNOLOG


INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (1,'PL');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (2,'EN');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (2,'PL');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (3,'EN');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (3,'PL');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (4,'PL');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (5,'PL');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (5,'EN');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (6,'PL');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (7,'PL');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (8,'PL');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (8,'EN');


INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja ginekologa', true, 1); --1
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja ginekologa', false, 1);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja radiologa', true, 2);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja radiologa', false, 2); --4
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja dermatologa', true, 3);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja dermatologa', false, 3); --6
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja internisty', true, 4);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja internisty', false, 4); --8
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja pediatry', true, 5);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja pediatry', false, 5); --10
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja okulisty', true, 6);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja okulisty', false, 6); --12
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja ortopedy', true, 7);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja ortopedy', false, 7); --14
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja endokrynologa', true, 8);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja endokrynologa', false, 8); --16
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja kardiologa', true, 9);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja kardiologa', false, 9);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja laryngologa', true, 10);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja laryngologa', false, 10);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja neurologa', true, 11);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja neurologa', false, 11);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja psychiatry', true, 12);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja psychiatry', false, 12);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja urologa', true, 13);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja urologa', false, 13);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja chirurga', true, 14);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja chirurga', false, 14);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja gastrologa', true, 15);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja gastrologa', false, 15);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG piersi', true, 2);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG jamy brzusznej', true, 1);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Gastroskopia', true, 15);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG nadgarstka', true, 7);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG stawu biodrowego', true, 7);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG stawu barkowego', true, 7);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG stawu kolanowego', true, 7);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG stawu łokciowego', true, 7);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG stawu skokowego', true, 7);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- nadgarstka', true, 2);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- nadnerczy', true, 2);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- podudzia', true, 2);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- przedramienia', true, 2);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- przysadki mózgowej', true, 2);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- ręki', true, 2);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- stawu biodrowego', true, 2);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- stopy', true, 2);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- uda', true, 2);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Rezonans magnetyczny- głowy', true, 2);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Soczewki kontaktowe- dobór', true, 6);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Komputerowe pole widzenia', true, 6);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Badanie EKG', true, 9);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Założenie Holtera EKG', true, 9);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Pobranie krwi i innych materiałów- na czczo', true, 4);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Pobranie krwi i innych materiałów- nie na czczo', true, 4);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Cytologia szyjki macicy', true, 1);


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
--Konsultacja ginekologa - Elżbieta Gos (1), Pacjent id 11
INSERT INTO appointment (STATE, DATE, DESCRIPTION, RECOMMENDATIONS, TYPE, DOCTOR_ID, MEDICAL_SERVICE_ID, PATIENT_ID)
VALUES ('DONE', '2021-11-18T12:45:00', 'Pacjent zgłosił następujące objawy: ból gardła i zatok, suchy kaszel. Zalecana wizyta kontrolna za 2 tygdonie',
        'Syrop flugamin 2/dz, ibuprom w przypadku gorączki,','FACILITY', 1, 7, 11);
INSERT INTO referral (EXPIRY_DATE, ISSUE_DATE, ISSUE_appointment_ID, MEDICAL_SERVICE_ID, PATIENT_ID) VALUES ('2022-01-31', '2021-11-18', 1, 7, 11);
INSERT INTO prescription (ACCESS_CODE, CREATION_DATE, EXPIRY_DATE, appointment_ID, PATIENT_ID)
VALUES (25689, '2021-11-18', '2021-12-18', 1, 11);
INSERT INTO appointment_check_up (doctors_description, appointment_id, check_up_id)
VALUES ('Badanie w celu wykluczenia zakażenia bakteryjnego', 1,1);

--Konsultacja dermatologa - Adam Staszewski (2), Pacjent id 1
INSERT INTO appointment (STATE, DATE, DESCRIPTION, RECOMMENDATIONS, TYPE, DOCTOR_ID, MEDICAL_SERVICE_ID, PATIENT_ID)
VALUES ('DONE', '2021-10-18T13:00:00', 'Delitakny trądzik na brodzie oraz czole. Po zakończeniu antybiotyku wizyta kontrolna', 'Antybiotyk 1dz/7dni','FACILITY', 2, 5, 11);
INSERT INTO referral (EXPIRY_DATE, ISSUE_DATE, ISSUE_appointment_ID, MEDICAL_SERVICE_ID, PATIENT_ID) VALUES ('2021-12-31', '2021-10-18', 2, 5, 11);
INSERT INTO prescription (ACCESS_CODE, CREATION_DATE, EXPIRY_DATE, APPOINTMENT_ID, PATIENT_ID)
VALUES (23241, '2021-10-18', '2021-12-18', 2, 11);
INSERT INTO appointment_check_up (doctors_description, result, appointment_id, check_up_id) VALUES ('Badanie w celu wykrycia baktorii odpowiedzialnej za trądzik', 'Nie wykryto bakterii',2,2);

--Konsultacja dermatologa - Adam Staszewski (2), Pacjent id 1
INSERT INTO appointment (STATE, DATE, DESCRIPTION, RECOMMENDATIONS, TYPE, DOCTOR_ID, MEDICAL_SERVICE_ID, PATIENT_ID)
VALUES ('DONE', '2021-09-18T13:00:00', 'Wizyta kontrolna z trądzikiem', 'Koniec przyjmowania antybiotyku','FACILITY', 2, 5, 11);
INSERT INTO referral (EXPIRY_DATE, ISSUE_DATE, ISSUE_appointment_ID, MEDICAL_SERVICE_ID, PATIENT_ID) VALUES ('2021-12-18', '2021-12-01', 2, 5, 11);
UPDATE referral SET APPOINTMENT_ID=3 WHERE ID=2; --WYKORZYSTANIE SKIEROWANIA Z POPRZEDNIEJ WIZYTY

--Konsultacja ginekologa - Elżbieta Gos (1), Pacjent id 2
INSERT INTO appointment (STATE, DATE, DESCRIPTION, RECOMMENDATIONS, TYPE, DOCTOR_ID, MEDICAL_SERVICE_ID, PATIENT_ID)
VALUES ('DONE', '2021-11-25T12:45:00', 'Pacjent zgłosił następujące objawy: ból gardła i zatok, suchy kaszel. Zalecana wizyta kontrolna za 2 tygdonie',
        'Syrop izoseft 2/dz, paracetamol w przypadku gorączki,','FACILITY',
        7, 7, 12);
INSERT INTO referral (EXPIRY_DATE, ISSUE_DATE, ISSUE_appointment_ID, MEDICAL_SERVICE_ID, PATIENT_ID) VALUES ('2022-01-31', '2021-11-18', 1, 7, 12);
INSERT INTO prescription (ACCESS_CODE, CREATION_DATE, EXPIRY_DATE, appointment_ID, PATIENT_ID)
VALUES (25689, '2021-11-18', '2021-12-18', 4, 12);
INSERT INTO appointment_check_up (doctors_description, result, appointment_id, check_up_id)
        VALUES ('Badanie w celu wykluczenia zakażenia bakteryjnego', 'Nie wykryto bakterii', 4,1);

--PULA WIZYT
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-14T18:00:00', 'FACILITY', 1, 1);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-13T18:30:00', 'FACILITY', 1, 1);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-10T17:00:00', 'FACILITY', 1, 1);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-11T10:30:00', 'FACILITY', 3, 3);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-18T12:45:00', 'FACILITY', 6, 6);

--POTWIERDZONE
INSERT INTO appointment (STATE, DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID, PATIENT_ID) VALUES ('CONFIRMED', CURRENT_TIMESTAMP(), 'FACILITY', 7, 1, 11);
INSERT INTO appointment (STATE, DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID, PATIENT_ID) VALUES ('CONFIRMED', CURRENT_TIMESTAMP(), 'FACILITY', 7, 1, 12);
INSERT INTO appointment (STATE, DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID, PATIENT_ID) VALUES ('CONFIRMED', CURRENT_TIMESTAMP(), 'TELEPHONE', 8, 1, 13);
INSERT INTO appointment (STATE, DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID, PATIENT_ID) VALUES ('CONFIRMED', CURRENT_TIMESTAMP(), 'TELEPHONE', 8, 1, 14);

--Ginekolog Elzbieta Gos
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-10T08:00:00', '2022-01-10T12:00:00', 1,1);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-11T10:00:00', '2022-01-11T14:00:00', 1,1);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-12T08:00:00', '2022-01-12T11:00:00', 1,1);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-12T14:00:00', '2022-01-12T17:00:00', 1,1);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-13T08:00:00', '2022-01-13T17:00:00', 1,1);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-14T13:00:00', '2022-01-14T17:00:00', 1,1);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-15T09:00:00', '2022-01-15T13:00:00', 1,1);

INSERT INTO medication (NAME, UNIT, QUANTITY) values ('Gynalgin', 'GRAMS', 100);

insert into patients_file (name, file, description, type, upload_date, patient_id) values ('zdj1', '123', 'lala', '.png', CURRENT_TIMESTAMP(),11);

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