-- helped to generate: https://aihelperbot.com/app

DELETE FROM helmes.sector;

INSERT INTO helmes.sector (sector_id, sector_name, sector_parent_id) VALUES
    (1, 'Manufacturing', NULL),
    (2, 'Construction materials', 1),
    (3, 'Electronics and Optics', 1),
    (4, 'Food and Beverage', 1),
    (5,'Bakery & confectionery products', 4),
    (6,'Beverages', 4),
    (7,'Fish & fish products', 4),
    (8,'Meat & meat products',4 ),
    (9,'Meat & dairy products', 4),
    (10,'Other', 4),
    (11,'Sweets & snack food', 4),
    (12,'Furniture', 1),
    (13,'Bathroom/sauna', 12),
    (14,'Bedroom', 12),
    (15,'Children’s room', 12),
    (16,'Kitchen', 12),
    (17,'Living room', 12),
    (18,'Office', 12),
    (19,'Other (Furniture)', 12),
    (20,'Outdoor', 12),
    (21,'Project furniture', 4),
    (22,'Machinery', 1),
    (23,'Machinery components', 4),
    (24,'Machinery components', 23),
    (25,'Machinery equipment/tools', 23),
    (26,'Manufacture of machinery', 23),
    (27,'Maritime', 23),
    (28,'Aluminium and steel workboats', 27),
    (29,'Boat/Yacht building', 27),
    (30,'Ship repair and conversion', 27),
    (31, 'Metal structures', 23),
    (32, 'Other', 23),
    (33, 'Repair and maintenance service', 23),
    (34, 'Metalworking', 1),
    (35, 'Construction of metal structures', 34),
    (36, 'Houses and buildings', 34),
    (37, 'Metal products', 34),
    (38, 'Metal works', 34),
    (39, 'CNC-machining', 38),
    (40, 'Forgings, Fasteners', 38),
    (41, 'Gas, Plasma, Laser cutting', 38),
    (42, 'MIG, TIG, Aluminum welding', 38),
    (43, 'Plastic and Rubber', 1),
    (44, 'Packaging', 43),
    (45, 'Plastic goods', 43),
    (46, 'Plastic processing technology', 43),
    (47, 'Blowing', 46),
    (48, 'Moulding', 46),
    (49, 'Plastics welding and processing', 46),
    (50, 'Plastic profiles', 46),
    (51, 'Printing', 1),
    (52, 'Advertising', 51),
    (53, 'Book/Periodicals printing', 51),
    (54, 'Labelling and packaging printing', 51),
    (55, 'Textile and Clothing', 1),
    (56, 'Clothing', 55),
    (57, 'Textile', 55),
    (58, 'Wood', 1),
    (59, 'Other (Wood)', 58),
    (60, 'Wooden building materials', 58),
    (61, 'Wooden houses', 58),
    (62, 'Other', 1),
    (63, 'Creative industries', 62),
    (64, 'Energy technology', 62),
    (65, 'Environment', 62),
    (66, 'Service', 1),
    (67, 'Business services', 66),
    (68, 'Engineering', 66),
    (69,'Information Technology and Telecommunications',66),
    (70,'Data processing, Web portals, E-marketing',69),
    (71, 'Programming, Consultancy', 69),
    (72, 'Software, Hardware', 69),
    (73, 'Telecommunications', 69),
    (74, 'Tourism', 62),
    (75, 'Translation services', 74),
    (76, 'Transport and Logistics', 62),
    (77, 'Air', 76),
    (78, 'Rail', 76),
    (79, 'Road', 76),
    (80, 'Water', 76);
