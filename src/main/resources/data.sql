INSERT INTO PUBLIC.POPULATION (POPULATIONID, NAME, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION, POPULATIONTYPE) VALUES (1, 'Served', TO_DATE('2009-09-10 16:00:20', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, null, 'Served');
INSERT INTO PUBLIC.POPULATION (POPULATIONID, NAME, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION, POPULATIONTYPE) VALUES (2, 'Pre-buffer', TO_DATE('2009-09-10 16:00:35', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, null, 'Baseline');
INSERT INTO PUBLIC.POPULATION (POPULATIONID, NAME, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION, POPULATIONTYPE) VALUES (3, 'Post-buffer', TO_DATE('2009-09-10 16:00:35', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, null, 'Baseline');
INSERT INTO PUBLIC.POPULATION (POPULATIONID, NAME, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION, POPULATIONTYPE) VALUES (4, 'Baseline', TO_DATE('2009-09-10 16:00:47', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, null, 'Baseline');
INSERT INTO PUBLIC.POPULATION (POPULATIONID, NAME, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION, POPULATIONTYPE) VALUES (5, 'Follow-up 19', TO_DATE('2009-09-10 16:00:37', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, null, 'Follow-up');
INSERT INTO PUBLIC.POPULATION (POPULATIONID, NAME, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION, POPULATIONTYPE) VALUES (6, 'Follow-up 21', TO_DATE('2009-09-10 16:00:43', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, null, 'Follow-up');

INSERT INTO PUBLIC.REGION (REGIONID, REGION, REGIONCODE, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (1, 'Region 1', '1', null, null, null, null, 'Boston');
INSERT INTO PUBLIC.REGION (REGIONID, REGION, REGIONCODE, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (2, 'Region 2', '2', null, null, null, null, 'New York');
INSERT INTO PUBLIC.REGION (REGIONID, REGION, REGIONCODE, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (3, 'Region 3', '3', null, null, null, null, 'Philadephia');
INSERT INTO PUBLIC.REGION (REGIONID, REGION, REGIONCODE, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (4, 'Region 4', '4', null, null, null, null, 'Atlanta');
INSERT INTO PUBLIC.REGION (REGIONID, REGION, REGIONCODE, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (5, 'Region 5', '5', null, null, null, null, 'Chicago');
INSERT INTO PUBLIC.REGION (REGIONID, REGION, REGIONCODE, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (6, 'Region 6', '6', null, null, null, null, 'Dallas');
INSERT INTO PUBLIC.REGION (REGIONID, REGION, REGIONCODE, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (7, 'Region 7', '7', null, null, null, null, 'Kansas City');
INSERT INTO PUBLIC.REGION (REGIONID, REGION, REGIONCODE, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (8, 'Region 8', '8', null, null, null, null, 'Denver');
INSERT INTO PUBLIC.REGION (REGIONID, REGION, REGIONCODE, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (9, 'Region 9', '9', null, null, null, null, 'San Francisco');
INSERT INTO PUBLIC.REGION (REGIONID, REGION, REGIONCODE, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (10, 'Region 10', '10', null, null, null, null, 'Seattle');

INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (2, 'Alaska', 'AK', '02', 10, null, null, null, null, 'Alaska');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (1, 'Alabama', 'AL', '01', 4, null, null, null, null, 'Alabama');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (4, 'Arizona', 'AZ', '04', 9, null, null, null, null, 'Arizona');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (5, 'Arkansas', 'AR', '05', 6, null, null, null, null, 'Arkansas');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (6, 'California', 'CA', '06', 9, null, null, null, null, 'California');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (7, 'Colorado', 'CO', '08', 8, null, null, null, null, 'Colorado');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (9, 'Connecticut', 'CT', '09', 1, null, null, null, null, 'Connecticut');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (10, 'Delaware', 'DE', '10', 3, null, null, null, null, 'Delaware');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (11, 'District of Columbia', 'DC', '11', 3, null, null, null, null, 'District of Columbia');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (13, 'Florida', 'FL', '12', 4, null, null, null, null, 'Florida');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (14, 'Georgia', 'GA', '13', 4, null, null, null, null, 'Georgia');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (16, 'Hawaii', 'HI', '15', 9, null, null, null, null, 'Hawaii');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (17, 'Idaho', 'ID', '16', 10, null, null, null, null, 'Idaho');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (18, 'Illinois', 'IL', '17', 5, null, null, null, null, 'Illinois');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (19, 'Indiana', 'IN', '18', 5, null, null, null, null, 'Indiana');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (20, 'Iowa', 'IA', '19', 7, null, null, null, null, 'Iowa');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (21, 'Kansas', 'KS', '20', 7, null, null, null, null, 'Kansas');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (22, 'Kentucky', 'KY', '21', 4, null, null, null, null, 'Kentucky');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (23, 'Louisiana', 'LA', '22', 6, null, null, null, null, 'Louisiana');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (24, 'Maine', 'ME', '23', 1, null, null, null, null, 'Maine');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (26, 'Maryland', 'MD', '24', 3, null, null, null, null, 'Maryland');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (27, 'Massachusetts', 'MA', '25', 1, null, null, null, null, 'Massachusetts');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (28, 'Michigan', 'MI', '26', 5, null, null, null, null, 'Michigan');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (29, 'Minnesota', 'MN', '27', 5, null, null, null, null, 'Minnesota');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (30, 'Mississippi', 'MS', '28', 4, null, null, null, null, 'Mississippi');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (31, 'Missouri', 'MO', '29', 7, null, null, null, null, 'Missouri');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (32, 'Montana', 'MT', '30', 8, null, null, null, null, 'Montana');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (33, 'Nebraska', 'NE', '31', 7, null, null, null, null, 'Nebraska');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (34, 'Nevada', 'NV', '32', 9, null, null, null, null, 'Nevada');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (35, 'New Hampshire', 'NH', '33', 1, null, null, null, null, 'New Hampshire');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (36, 'New Jersey', 'NJ', '34', 2, null, null, null, null, 'New Jersey');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (37, 'New Mexico', 'NM', '35', 6, null, null, null, null, 'New Mexico');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (38, 'New York', 'NY', '36', 2, null, null, null, null, 'New York');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (39, 'North Carolina', 'NC', '37', 4, null, null, null, null, 'North Carolina');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (40, 'North Dakota', 'ND', '38', 8, null, null, null, null, 'North Dakota');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (41, 'Ohio', 'OH', '39', 5, null, null, null, null, 'Ohio');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (42, 'Oklahoma', 'OK', '40', 6, null, null, null, null, 'Oklahoma');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (43, 'Oregon', 'OR', '41', 10, null, null, null, null, 'Oregon');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (44, 'Pennsylvania', 'PA', '42', 3, null, null, null, null, 'Pennsylvania');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (45, 'Puerto Rico', 'PR', '72', 2, null, null, null, null, 'Puerto Rico');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (47, 'Rhode Island', 'RI', '44', 1, null, null, null, null, 'Rhode Island');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (48, 'South Carolina', 'SC', '45', 4, null, null, null, null, 'South Carolina');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (49, 'South Dakota', 'SD', '46', 8, null, null, null, null, 'South Dakota');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (50, 'Tennessee', 'TN', '47', 4, null, null, null, null, 'Tennessee');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (51, 'Texas', 'TX', '48', 6, null, null, null, null, 'Texas');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (52, 'Utah', 'UT', '49', 8, null, null, null, null, 'Utah');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (53, 'Vermont', 'VT', '50', 1, null, null, null, null, 'Vermont');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (55, 'Virginia', 'VA', '51', 3, null, null, null, null, 'Virginia');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (56, 'Washington', 'WA', '53', 10, null, null, null, null, 'Washington');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (57, 'West Virginia', 'WV', '54', 3, null, null, null, null, 'West Virginia');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (58, 'Wisconsin', 'WI', '55', 5, null, null, null, null, 'Wisconsin');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (59, 'Wyoming', 'WY', '56', 8, null, null, null, null, 'Wyoming');
INSERT INTO PUBLIC.STATE (STATEID, STATENAME, ABBREVIATION, FIPSCODE, REGIONID, CREATEDDATE, CREATEDBY, UPDATEDATE, UPDATEBY, DESCRIPTION) VALUES (60, 'Test State', 'ST', '57', 1, null, null, null, null, 'Test State');

