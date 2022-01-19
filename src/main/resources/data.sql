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
INSERT INTO person (BIRTH_DATE, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1970-09-16', 'Anna', 'Swatek', '69041861586');
INSERT INTO person (BIRTH_DATE, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1987-09-18', 'Monika', 'Jonkisz', '87091872657');
INSERT INTO person (BIRTH_DATE, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1992-10-04', 'Klara', 'Rozbicka', '92100484578');
INSERT INTO person (BIRTH_DATE, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1960-09-09', 'Paweł', 'Stasiak', '60090916319');
INSERT INTO person (BIRTH_DATE, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1958-09-20', 'Tomasz', 'Rosiak', '58092013325');
INSERT INTO person (BIRTH_DATE, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1996-07-29', 'Magdalena', 'Ochnik', '96072983626');

--pacjenci
INSERT INTO person (BIRTH_DATE, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1969-01-14', 'Jan', 'Kowalski', '69011471496');
INSERT INTO person (BIRTH_DATE, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1998-11-10', 'Adam', 'Nowak', '98111005401');
INSERT INTO person (BIRTH_DATE, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1998-05-10', 'Adam', 'Kochanowski', '86012028991');
INSERT INTO person (BIRTH_DATE, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1998-05-10', 'Aldona', 'Słowik', '94060431348');
INSERT INTO person (BIRTH_DATE, FIRST_NAME, LAST_NAME, PESEL) VALUES ('1960-04-30', 'Anna', 'Morawska', '60043064267');
INSERT INTO patient (CITY, COUNTRY, POST_CODE, STREET, STREET_NUMBER, PHONE_NUMBER, ID) VALUES ('Lublin', 'Polska', '20-040', 'Sowińskiego', '18/20', '604456897', 16);
INSERT INTO patient (CITY, COUNTRY, POST_CODE, STREET, STREET_NUMBER, PHONE_NUMBER, ID) VALUES ('Warszawa', 'Polska', '01-172', 'Marszałkowska', '14/89', '503273947', 17);
INSERT INTO patient (CITY, COUNTRY, POST_CODE, STREET, STREET_NUMBER, PHONE_NUMBER, ID) VALUES ('Piaseczno', 'Polska', '20-040', 'Nadarzyńska', '47/12', '726326900', 18);
INSERT INTO patient (CITY, COUNTRY, POST_CODE, STREET, STREET_NUMBER, PHONE_NUMBER, ID) VALUES ('Warszawa', 'Polska', '02-128', 'Puławska', '67/16', '745927345', 19);
INSERT INTO patient (CITY, COUNTRY, POST_CODE, STREET, STREET_NUMBER, PHONE_NUMBER, ID) VALUES ('Ryki', 'Polska', '08-500', 'Swatowska', '58', '604568898', 20);


INSERT INTO doctor (PWZ, ID) VALUES ('2564897', 1);
INSERT INTO doctor (PWZ, ID) VALUES ('5698742', 2);
INSERT INTO doctor (PWZ, ID) VALUES ('7303243', 3);
INSERT INTO doctor (PWZ, ID) VALUES ('3534578', 4);
INSERT INTO doctor (PWZ, ID) VALUES ('5642562', 5);
INSERT INTO doctor (PWZ, ID) VALUES ('8747824', 6);
INSERT INTO doctor (PWZ, ID) VALUES ('5462456', 7);
INSERT INTO doctor (PWZ, ID) VALUES ('9753423', 8);
INSERT INTO doctor (PWZ, ID) VALUES ('4567531', 9);
INSERT INTO doctor (PWZ, ID) VALUES ('1258694', 10);
INSERT INTO doctor (PWZ, ID) VALUES ('4569525', 11);
INSERT INTO doctor (PWZ, ID) VALUES ('8526548', 12);
INSERT INTO doctor (PWZ, ID) VALUES ('1145684', 13);
INSERT INTO doctor (PWZ, ID) VALUES ('0025645', 14);
INSERT INTO doctor (PWZ, ID) VALUES ('7536548', 15);


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
INSERT INTO doctor_specialization (DOCTOR_ID, SPECIALIZATION_ID) VALUES (9,9); --KARDIOLOG
INSERT INTO doctor_specialization (DOCTOR_ID, SPECIALIZATION_ID) VALUES (10,10); --LARYNGOLOG
INSERT INTO doctor_specialization (DOCTOR_ID, SPECIALIZATION_ID) VALUES (11,11); --NEUROLOG
INSERT INTO doctor_specialization (DOCTOR_ID, SPECIALIZATION_ID) VALUES (12,12); --PSYCHIATRA
INSERT INTO doctor_specialization (DOCTOR_ID, SPECIALIZATION_ID) VALUES (13,13); --UROLOG
INSERT INTO doctor_specialization (DOCTOR_ID, SPECIALIZATION_ID) VALUES (14,14); --CHIRURG
INSERT INTO doctor_specialization (DOCTOR_ID, SPECIALIZATION_ID) VALUES (15,15); --GASTROLOG


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
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (9,'PL');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (9,'EN');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (10,'PL');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (10,'EN');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (11, 'PL');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (11, 'EN');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (12, 'PL');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (12, 'EN');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (13, 'PL');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (13, 'EN');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (14, 'PL');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (14, 'EN');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (15, 'PL');
INSERT INTO language (DOCTOR_ID, DOCTOR_language) VALUES (15, 'EN');

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
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja kardiologa', false, 9); --18
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja laryngologa', true, 10);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja laryngologa', false, 10); --20
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja neurologa', true, 11);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja neurologa', false, 11); --22
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja psychiatry', true, 12);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja psychiatry', false, 12); --24
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja urologa', true, 13);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja urologa', false, 13); --26
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja chirurga', true, 14);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja chirurga', false, 14); --28
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Konsultacja gastrologa', true, 15);
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Teleporada- Konsultacja gastrologa', false, 15); --30
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG piersi', true, 2); --31
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG jamy brzusznej', true, 1); --32
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('Gastroskopia', true, 15); --33
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG nadgarstka', true, 7); --34
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG stawu biodrowego', true, 7); --35
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG stawu barkowego', true, 7); --36
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG stawu kolanowego', true, 7); --37
INSERT INTO medical_service(NAME, FACILITY_SERVICE, SPECIALIZATION_ID) VALUES ('USG stawu łokciowego', true, 7); --38
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
        'Syrop flugamin 2/dz, ibuprom w przypadku gorączki,','FACILITY', 1, 7, 16);
INSERT INTO referral (EXPIRY_DATE, ISSUE_DATE, ISSUE_appointment_ID, MEDICAL_SERVICE_ID, PATIENT_ID) VALUES ('2022-01-31', '2021-11-18', 1, 7, 16);
INSERT INTO prescription (ACCESS_CODE, CREATION_DATE, EXPIRY_DATE, appointment_ID, PATIENT_ID)
VALUES (25689, '2021-11-18', '2021-12-18', 1, 16);
INSERT INTO appointment_check_up (doctors_description, appointment_id, check_up_id)
VALUES ('Badanie w celu wykluczenia zakażenia bakteryjnego', 1,1);

--Konsultacja dermatologa - Adam Staszewski (2), Pacjent id 1
INSERT INTO appointment (STATE, DATE, DESCRIPTION, RECOMMENDATIONS, TYPE, DOCTOR_ID, MEDICAL_SERVICE_ID, PATIENT_ID)
VALUES ('DONE', '2021-10-18T13:00:00', 'Delitakny trądzik na brodzie oraz czole. Po zakończeniu antybiotyku wizyta kontrolna', 'Antybiotyk 1dz/7dni','FACILITY', 2, 5, 16);
INSERT INTO referral (EXPIRY_DATE, ISSUE_DATE, ISSUE_appointment_ID, MEDICAL_SERVICE_ID, PATIENT_ID) VALUES ('2021-12-31', '2021-10-18', 2, 5, 16);
INSERT INTO prescription (ACCESS_CODE, CREATION_DATE, EXPIRY_DATE, APPOINTMENT_ID, PATIENT_ID)
VALUES (23241, '2021-10-18', '2021-12-18', 2, 16);
INSERT INTO appointment_check_up (doctors_description, result, appointment_id, check_up_id) VALUES ('Badanie w celu wykrycia baktorii odpowiedzialnej za trądzik', 'Nie wykryto bakterii',2,2);

--Konsultacja dermatologa - Adam Staszewski (2), Pacjent id 1
INSERT INTO appointment (STATE, DATE, DESCRIPTION, RECOMMENDATIONS, TYPE, DOCTOR_ID, MEDICAL_SERVICE_ID, PATIENT_ID)
VALUES ('DONE', '2021-09-18T13:00:00', 'Wizyta kontrolna z trądzikiem', 'Koniec przyjmowania antybiotyku','FACILITY', 2, 5, 16);
INSERT INTO referral (EXPIRY_DATE, ISSUE_DATE, ISSUE_appointment_ID, MEDICAL_SERVICE_ID, PATIENT_ID) VALUES ('2021-12-18', '2021-12-01', 2, 5, 16);
UPDATE referral SET APPOINTMENT_ID=3 WHERE ID=2; --WYKORZYSTANIE SKIEROWANIA Z POPRZEDNIEJ WIZYTY

--Konsultacja ginekologa - Elżbieta Gos (1), Pacjent id 2
INSERT INTO appointment (STATE, DATE, DESCRIPTION, RECOMMENDATIONS, TYPE, DOCTOR_ID, MEDICAL_SERVICE_ID, PATIENT_ID)
VALUES ('DONE', '2021-11-25T12:45:00', 'Pacjent zgłosił następujące objawy: ból gardła i zatok, suchy kaszel. Zalecana wizyta kontrolna za 2 tygdonie',
        'Syrop izoseft 2/dz, paracetamol w przypadku gorączki,','FACILITY',
        7, 7, 17);
INSERT INTO referral (EXPIRY_DATE, ISSUE_DATE, ISSUE_appointment_ID, MEDICAL_SERVICE_ID, PATIENT_ID) VALUES ('2022-01-31', '2021-12-30', 1, 7, 17);
INSERT INTO prescription (ACCESS_CODE, CREATION_DATE, EXPIRY_DATE, appointment_ID, PATIENT_ID)
VALUES (25689, '2021-11-18', '2021-12-18', 4, 17);
INSERT INTO appointment_check_up (doctors_description, result, appointment_id, check_up_id)
VALUES ('Badanie w celu wykluczenia zakażenia bakteryjnego', 'Nie wykryto bakterii', 4,1);

--PULA WIZYT
--ginekolog
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-24T12:00:00', 'FACILITY', 1, 1);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-24T11:30:00', 'FACILITY', 1, 1);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-25T13:00:00', 'FACILITY', 1, 1);

--radiolog
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-21T10:00:00', 'FACILITY', 3, 2);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-24T10:30:00', 'FACILITY', 3, 2);

--dermatolog
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-25T12:45:00', 'FACILITY', 5, 3);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-26T09:45:00', 'FACILITY', 5, 3);

--internista
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-24T09:45:00', 'FACILITY', 7, 4);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-25T12:15:00', 'TELEPHONE', 8, 4);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-26T12:45:00', 'TELEPHONE', 8, 4);

--pediatra
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-21T10:00:00', 'FACILITY', 9, 5);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-21T10:45:00', 'FACILITY', 9, 5);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-25T11:45:00', 'TELEPHONE', 10, 5);

--okulista
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-25T09:00:00', 'FACILITY', 11, 6);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-25T09:30:00', 'FACILITY', 11, 6);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-25T10:00:00', 'FACILITY', 11, 6);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-25T10:30:00', 'FACILITY', 11, 6);

--ortopeda
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-21T08:30:00', 'FACILITY', 13, 7);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-21T09:00:00', 'FACILITY', 13, 7);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-21T10:00:00', 'FACILITY', 13, 7);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-21T12:00:00', 'TELEPHONE', 14, 7);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-24T12:30:00', 'TELEPHONE', 14, 7);

--endokrynolog
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-21T10:00:00', 'TELEPHONE', 16, 8);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-21T10:30:00', 'TELEPHONE', 16, 8);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-21T11:00:00', 'TELEPHONE', 16, 8);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-21T09:00:00', 'FACILITY', 15, 8);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-20T10:00:00', 'FACILITY', 15, 8);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-20T10:30:00', 'FACILITY', 15, 8);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-20T11:00:00', 'FACILITY', 15, 8);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-20T11:30:00', 'FACILITY', 15, 8);

--kardiolog
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-24T09:30:00', 'FACILITY', 17, 9);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-24T12:00:00', 'FACILITY', 17, 9);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-24T12:30:00', 'FACILITY', 52, 9);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-24T15:00:00', 'TELEPHONE', 18, 9);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-24T15:30:00', 'TELEPHONE', 18, 9);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-24T16:00:00', 'TELEPHONE', 18, 9);

--laryngolog
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-20T09:00:00', 'FACILITY', 19, 10);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-20T10:00:00', 'FACILITY', 19, 10);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-20T14:00:00', 'FACILITY', 19, 10);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-21T09:00:00', 'FACILITY', 19, 10);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-24T10:30:00', 'FACILITY', 19, 10);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-24T08:30:00', 'FACILITY', 19, 10);

--neurolog
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-20T09:00:00', 'FACILITY', 21, 11);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-20T10:00:00', 'FACILITY', 21, 11);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-20T14:00:00', 'FACILITY', 21, 11);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-21T09:00:00', 'FACILITY', 21, 11);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-11T10:30:00', 'TELEPHONE', 22, 11);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-24T08:30:00', 'TELEPHONE', 22, 11);

--psychiatra
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-24T09:00:00', 'FACILITY', 23, 12);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-24T10:00:00', 'FACILITY', 23, 12);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-24T14:00:00', 'FACILITY', 23, 12);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-25T09:00:00', 'FACILITY', 23, 12);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-25T10:30:00', 'TELEPHONE', 24, 12);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-26T08:30:00', 'TELEPHONE', 24, 12);

--urolog
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-21T09:00:00', 'FACILITY', 25, 13);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-22T10:00:00', 'FACILITY', 25, 13);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-21T14:00:00', 'FACILITY', 25, 13);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-22T09:00:00', 'FACILITY', 25, 13);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-24T09:00:00', 'FACILITY', 25, 13);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-24T10:00:00', 'FACILITY', 25, 13);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-24T14:00:00', 'FACILITY', 25, 13);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-25T09:00:00', 'FACILITY', 25, 13);

--chirurg
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-21T09:00:00', 'FACILITY', 27, 14);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-27T10:00:00', 'FACILITY', 27, 14);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-21T14:00:00', 'FACILITY', 27, 14);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-27T09:00:00', 'FACILITY', 27, 14);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-24T09:00:00', 'FACILITY', 27, 14);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-24T10:00:00', 'FACILITY', 27, 14);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-24T14:00:00', 'FACILITY', 27, 14);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-25T09:00:00', 'FACILITY', 27, 14);

--gastrolog
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-21T09:00:00', 'FACILITY', 29, 15);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-22T10:00:00', 'FACILITY', 29, 15);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-21T14:00:00', 'FACILITY', 29, 15);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-22T09:00:00', 'FACILITY', 29, 15);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-24T09:00:00', 'FACILITY', 29, 15);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-24T10:00:00', 'FACILITY', 29, 15);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-24T14:00:00', 'TELEPHONE', 30, 15);
INSERT INTO appointment (DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID) VALUES ('2022-01-25T09:00:00', 'TELEPHONE', 30, 15);

--POTWIERDZONE
INSERT INTO appointment (STATE, DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID, PATIENT_ID) VALUES ('CONFIRMED', CURRENT_TIMESTAMP(), 'FACILITY', 7, 1, 16);
INSERT INTO appointment (STATE, DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID, PATIENT_ID) VALUES ('CONFIRMED', CURRENT_TIMESTAMP(), 'FACILITY', 7, 1, 16);
INSERT INTO appointment (STATE, DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID, PATIENT_ID) VALUES ('CONFIRMED', CURRENT_TIMESTAMP(), 'TELEPHONE', 8, 1, 18);
INSERT INTO appointment (STATE, DATE, TYPE, MEDICAL_SERVICE_ID, DOCTOR_ID, PATIENT_ID) VALUES ('CONFIRMED', CURRENT_TIMESTAMP(), 'TELEPHONE', 8, 1, 19);

--Ginekolog Elzbieta Gos
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-17T08:00:00', '2022-01-17T12:00:00', 1,1);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-18T10:00:00', '2022-01-18T14:00:00', 1,1);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-19T08:00:00', '2022-01-19T11:00:00', 1,1);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-19T14:00:00', '2022-01-19T17:00:00', 1,1);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-20T08:00:00', '2022-01-20T17:00:00', 1,1);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-21T13:00:00', '2022-01-21T17:00:00', 1,1);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-22T09:00:00', '2022-01-22T13:00:00', 1,1);

insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-24T08:00:00', '2022-01-24T12:00:00', 1,1);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-25T10:00:00', '2022-01-25T14:00:00', 1,1);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-26T08:00:00', '2022-01-26T11:00:00', 1,1);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-26T14:00:00', '2022-01-26T17:00:00', 1,1);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-27T08:00:00', '2022-01-27T17:00:00', 1,1);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-28T13:00:00', '2022-01-28T17:00:00', 1,1);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-29T09:00:00', '2022-01-29T13:00:00', 1,1);

--Radiolog Adam Staszewski
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-17T08:00:00', '2022-01-17T16:00:00', 2,2);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-18T08:00:00', '2022-01-18T16:00:00', 2,2);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-19T08:00:00', '2022-01-19T12:00:00', 2,2);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-20T08:00:00', '2022-01-20T16:00:00', 2,2);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-21T10:00:00', '2022-01-21T17:00:00', 2,2);

insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-24T08:00:00', '2022-01-24T16:00:00', 2,2);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-25T08:00:00', '2022-01-25T16:00:00', 2,2);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-26T08:00:00', '2022-01-26T12:00:00', 2,2);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-27T08:00:00', '2022-01-27T16:00:00', 2,2);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-28T10:00:00', '2022-01-28T17:00:00', 2,2);

--Dermatolog Barbara Nowak
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-17T08:00:00', '2022-01-17T16:00:00', 3,3);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-18T08:00:00', '2022-01-18T16:00:00', 3,3);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-19T08:00:00', '2022-01-19T16:00:00', 3,3);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-20T08:00:00', '2022-01-20T16:00:00', 3,3);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-21T08:00:00', '2022-01-21T13:00:00', 3,3);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-22T08:00:00', '2022-01-22T12:00:00', 3,3);

insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-24T08:00:00', '2022-01-24T16:00:00', 3,3);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-25T08:00:00', '2022-01-25T16:00:00', 3,3);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-26T08:00:00', '2022-01-26T16:00:00', 3,3);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-27T08:00:00', '2022-01-27T16:00:00', 3,3);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-28T08:00:00', '2022-01-28T13:00:00', 3,3);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-29T08:00:00', '2022-01-29T12:00:00', 3,3);

--Internista Elżbieta Gos
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-17T09:00:00', '2022-01-17T16:00:00', 4,4);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-18T09:00:00', '2022-01-18T16:00:00', 4,4);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-19T09:00:00', '2022-01-19T16:00:00', 4,4);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-20T09:00:00', '2022-01-20T16:00:00', 4,4);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-21T09:00:00', '2022-01-21T16:00:00', 4,4);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-22T09:00:00', '2022-01-22T12:00:00', 4,4);

insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-24T09:00:00', '2022-01-24T16:00:00', 4,4);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-25T09:00:00', '2022-01-25T16:00:00', 4,4);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-26T09:00:00', '2022-01-26T16:00:00', 4,4);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-27T09:00:00', '2022-01-27T16:00:00', 4,4);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-28T09:00:00', '2022-01-28T16:00:00', 4,4);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-29T09:00:00', '2022-01-29T12:00:00', 4,4);

--Pediatra Kamil Górnicki
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-17T08:00:00', '2022-01-17T16:00:00', 5,5);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-18T08:00:00', '2022-01-18T16:00:00', 5,5);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-19T08:00:00', '2022-01-19T12:00:00', 5,5);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-20T08:00:00', '2022-01-20T16:00:00', 5,5);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-21T10:00:00', '2022-01-21T17:00:00', 5,5);

insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-24T08:00:00', '2022-01-24T16:00:00', 5,5);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-25T08:00:00', '2022-01-25T16:00:00', 5,5);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-26T08:00:00', '2022-01-26T12:00:00', 5,5);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-27T08:00:00', '2022-01-27T16:00:00', 5,5);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-28T10:00:00', '2022-01-28T17:00:00', 5,5);

--Okulista Aleksandra Nowicka
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-17T09:00:00', '2022-01-17T16:00:00', 6,6);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-18T09:00:00', '2022-01-18T16:00:00', 6,6);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-19T09:00:00', '2022-01-19T16:00:00', 6,6);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-20T09:00:00', '2022-01-20T16:00:00', 6,6);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-21T09:00:00', '2022-01-21T16:00:00', 6,6);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-22T08:00:00', '2022-01-22T14:00:00', 6,6);

insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-24T09:00:00', '2022-01-24T16:00:00', 6,6);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-25T09:00:00', '2022-01-25T16:00:00', 6,6);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-26T09:00:00', '2022-01-26T16:00:00', 6,6);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-27T09:00:00', '2022-01-27T16:00:00', 6,6);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-28T09:00:00', '2022-01-28T16:00:00', 6,6);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-29T08:00:00', '2022-01-29T14:00:00', 6,6);


--Ortopeda Piotr Olewnik
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-17T08:00:00', '2022-01-17T12:00:00', 7,7);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-18T10:00:00', '2022-01-18T16:00:00', 7,7);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-19T08:00:00', '2022-01-19T11:00:00', 7,7);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-19T14:00:00', '2022-01-19T17:00:00', 7,7);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-20T08:00:00', '2022-01-20T17:00:00', 7,7);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-21T13:00:00', '2022-01-21T17:00:00', 7,7);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-22T09:00:00', '2022-01-22T13:00:00', 7,7);

insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-24T08:00:00', '2022-01-24T12:00:00', 7,7);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-25T10:00:00', '2022-01-25T16:00:00', 7,7);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-26T08:00:00', '2022-01-26T11:00:00', 7,7);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-26T14:00:00', '2022-01-26T17:00:00', 7,7);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-27T08:00:00', '2022-01-27T17:00:00', 7,7);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-28T13:00:00', '2022-01-28T17:00:00', 7,7);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-29T09:00:00', '2022-01-29T13:00:00', 7,7);

--Endokrynolog Tomasz Król
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-17T08:00:00', '2022-01-17T16:00:00', 8,8);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-18T08:00:00', '2022-01-18T16:00:00', 8,8);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-19T08:00:00', '2022-01-19T16:00:00', 8,8);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-20T08:00:00', '2022-01-20T16:00:00', 8,8);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-21T10:00:00', '2022-01-21T16:00:00', 8,8);

insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-24T08:00:00', '2022-01-24T16:00:00', 8,8);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-25T08:00:00', '2022-01-25T16:00:00', 8,8);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-26T08:00:00', '2022-01-26T16:00:00', 8,8);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-27T08:00:00', '2022-01-27T16:00:00', 8,8);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-28T10:00:00', '2022-01-28T16:00:00', 8,8);


--Kardiolog Monika Loch
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-17T08:00:00', '2022-01-17T16:00:00', 9,9);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-18T10:00:00', '2022-01-18T16:00:00', 9,9);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-19T08:00:00', '2022-01-19T11:00:00', 9,9);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-19T14:00:00', '2022-01-19T17:00:00', 9,9);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-20T08:00:00', '2022-01-20T17:00:00', 9,9);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-21T13:00:00', '2022-01-21T17:00:00', 9,9);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-22T09:00:00', '2022-01-22T13:00:00', 9,9);

insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-24T08:00:00', '2022-01-24T16:00:00', 9,9);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-25T10:00:00', '2022-01-25T16:00:00', 9,9);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-26T08:00:00', '2022-01-26T11:00:00', 9,9);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-26T14:00:00', '2022-01-26T17:00:00', 9,9);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-27T08:00:00', '2022-01-27T17:00:00', 9,9);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-28T13:00:00', '2022-01-28T17:00:00', 9,9);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-29T09:00:00', '2022-01-29T13:00:00', 9,9);

--Laryngolog Anna Swatek
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-17T08:00:00', '2022-01-17T16:00:00', 10,10);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-18T08:00:00', '2022-01-18T16:00:00', 10,10);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-19T08:00:00', '2022-01-19T15:00:00', 10,10);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-20T08:00:00', '2022-01-20T16:00:00', 10,10);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-21T10:00:00', '2022-01-21T17:00:00', 10,10);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-22T08:00:00', '2022-01-22T13:00:00', 10,10);

insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-24T08:00:00', '2022-01-24T16:00:00', 10,10);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-25T08:00:00', '2022-01-25T16:00:00', 10,10);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-26T08:00:00', '2022-01-26T15:00:00', 10,10);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-27T08:00:00', '2022-01-27T16:00:00', 10,10);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-28T10:00:00', '2022-01-28T17:00:00', 10,10);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-29T08:00:00', '2022-01-29T13:00:00', 10,10);

--Neurolog Monika Jonkisz
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-17T09:00:00', '2022-01-17T16:00:00', 11,11);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-18T09:00:00', '2022-01-18T16:00:00', 11,11);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-19T09:00:00', '2022-01-19T16:00:00', 11,11);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-20T09:00:00', '2022-01-20T16:00:00', 11,11);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-21T09:00:00', '2022-01-21T16:00:00', 11,11);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-22T09:00:00', '2022-01-22T12:00:00', 11,11);

insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-24T09:00:00', '2022-01-24T16:00:00', 11,11);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-25T09:00:00', '2022-01-25T16:00:00', 11,11);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-26T09:00:00', '2022-01-26T16:00:00', 11,11);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-27T09:00:00', '2022-01-27T16:00:00', 11,11);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-28T09:00:00', '2022-01-28T16:00:00', 11,11);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-29T09:00:00', '2022-01-29T12:00:00', 11,11);

--Psychiatra Klara Rozbicka
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-17T08:00:00', '2022-01-17T12:00:00', 12,12);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-18T10:00:00', '2022-01-18T16:00:00', 12,12);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-19T08:00:00', '2022-01-19T11:00:00', 12,12);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-19T14:00:00', '2022-01-19T17:00:00', 12,12);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-20T08:00:00', '2022-01-20T17:00:00', 12,12);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-21T13:00:00', '2022-01-21T17:00:00', 12,12);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-22T09:00:00', '2022-01-22T13:00:00', 12,12);

insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-24T08:00:00', '2022-01-24T12:00:00', 12,12);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-25T10:00:00', '2022-01-25T16:00:00', 12,12);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-26T08:00:00', '2022-01-26T11:00:00', 12,12);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-26T14:00:00', '2022-01-26T17:00:00', 12,12);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-27T08:00:00', '2022-01-27T17:00:00', 12,12);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-28T13:00:00', '2022-01-28T17:00:00', 12,12);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-29T09:00:00', '2022-01-29T13:00:00', 12,12);

--Urolog Paweł Stasiak
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-17T08:00:00', '2022-01-17T16:00:00', 13,13);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-18T08:00:00', '2022-01-18T16:00:00', 13,13);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-19T08:00:00', '2022-01-19T16:00:00', 13,13);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-20T08:00:00', '2022-01-20T16:00:00', 13,13);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-21T10:00:00', '2022-01-21T16:00:00', 13,13);

insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-24T08:00:00', '2022-01-24T16:00:00', 13,13);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-25T08:00:00', '2022-01-25T16:00:00', 13,13);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-26T08:00:00', '2022-01-26T16:00:00', 13,13);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-27T08:00:00', '2022-01-27T16:00:00', 13,13);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-28T10:00:00', '2022-01-28T16:00:00', 13,13);

--Chirurg Tomasz Rosiak
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-17T08:00:00', '2022-01-17T16:00:00', 14,14);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-18T08:00:00', '2022-01-18T16:00:00', 14,14);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-19T08:00:00', '2022-01-19T12:00:00', 14,14);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-20T08:00:00', '2022-01-20T16:00:00', 14,14);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-21T10:00:00', '2022-01-21T17:00:00', 14,14);

insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-24T08:00:00', '2022-01-24T16:00:00', 14,14);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-25T08:00:00', '2022-01-25T16:00:00', 14,14);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-26T08:00:00', '2022-01-26T12:00:00', 14,14);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-27T08:00:00', '2022-01-27T16:00:00', 14,14);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-28T10:00:00', '2022-01-28T17:00:00', 14,14);

--Gastrolog Magdalena Ochnik
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-17T08:00:00', '2022-01-17T16:00:00', 15,15);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-18T08:00:00', '2022-01-18T16:00:00', 15,15);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-19T08:00:00', '2022-01-19T12:00:00', 15,15);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-20T08:00:00', '2022-01-20T16:00:00', 15,15);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-21T10:00:00', '2022-01-21T17:00:00', 15,15);

insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-24T08:00:00', '2022-01-24T16:00:00', 15,15);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-25T08:00:00', '2022-01-25T16:00:00', 15,15);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-26T08:00:00', '2022-01-26T12:00:00', 15,15);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-27T08:00:00', '2022-01-27T16:00:00', 15,15);
insert into schedule (Date_from, Date_to, doctor_id, specialization_id) values ('2022-01-28T10:00:00', '2022-01-28T17:00:00', 15,15);


INSERT INTO medication (NAME, UNIT, QUANTITY) values ('Gynalgin', 'GRAMS', 100);
INSERT INTO medication (NAME, UNIT, QUANTITY) values ('Unidox', 'GRAMS', 250);
INSERT INTO medication (NAME, UNIT, QUANTITY) values ('Pimafucort', 'GRAMS', 40);
INSERT INTO medication (NAME, UNIT, QUANTITY) values ('Duomox', 'GRAMS', 200);
INSERT INTO medication (NAME, UNIT, QUANTITY) values ('Acnatac', 'GRAMS', 400);
INSERT INTO medication (NAME, UNIT, QUANTITY) values ('Amotaks', 'GRAMS', 100);
INSERT INTO medication (NAME, UNIT, QUANTITY) values ('Clobederm', 'GRAMS', 100);
INSERT INTO medication (NAME, UNIT, QUANTITY) values ('Mupirox', 'GRAMS', 100);

insert into PRESCRIPTION_MEDICATION (prescription_id, medication_id, number_of_packages, dosing) values (1, 1, 1, 'raz dziennie');
insert into PRESCRIPTION_MEDICATION (prescription_id, medication_id, number_of_packages, dosing) values (2, 2, 1, '2 razy dziennie, rano i wieczorem x1');