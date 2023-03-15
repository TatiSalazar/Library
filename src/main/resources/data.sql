INSERT INTO public.faculty (faculty_id,"name") VALUES
	 (1,'Ingeniería'),
	 (2,'Salud');

INSERT INTO public.academic_program (program_id,"name",faculty_faculty_id) VALUES
	 (1,'Sistemas y Computación',1),
	 (2,'Electrónica',1),
	 (3,'Medicina',2),
	 (4,'Enfermería',2);

INSERT INTO public.faculty_academic_programs (faculty_faculty_id,academic_programs_program_id) VALUES
	 (1,1),
	 (1,2),
	 (2,3),
	 (2,4);

INSERT INTO public.student ("document",email,"name",phone,type_document,academic_program_program_id) VALUES
	 ('82-965-6514','sannis0@universal.edu.co','Sophi','549-591-5789','CC',1),
	 ('78-256-3500','asanderson1@universal.edu.co','Ashley','755-973-6388','TI',2),
	 ('96-406-0045','sdyke2@universal.edu.co','Sharona','897-455-2795','CC',3),
	 ('02-479-4831','kjuanes3@universal.edu.co','Katee','904-495-7898','CC',4),
	 ('96-989-8506','jbreffitt4@universal.edu.co','Jemie','732-292-8359','TI',1),
	 ('65-828-7410','slawman5@universal.edu.co','Shandeigh','418-629-6003','CC',2),
	 ('08-099-0411','jbainbrigge6@universal.edu.co','Janaye','814-752-2095','CC',3),
	 ('24-929-9124','kletixier7@universal.edu.co','Kiley','859-196-4108','TI',4),
	 ('17-285-7753','lhappel8@universal.edu.co','Lyda','519-750-0714','CC',1),
	 ('95-079-7574','mhexham9@universal.edu.co','Micaela','626-475-1884','TI',2);
INSERT INTO public.student ("document",email,"name",phone,type_document,academic_program_program_id) VALUES
	 ('87-167-9521','ccranidgea@universal.edu.co','Caprice','619-866-6229','TI',3),
	 ('47-571-1641','atruettb@universal.edu.co','Austin','272-357-0922','CC',4),
	 ('95-778-9851','jwiddowsc@universal.edu.co','Jobyna','766-357-7172','TI',1),
	 ('75-941-0599','bsweedd@universal.edu.co','Berta','898-815-7393','CC',2),
	 ('41-411-2619','nwynesse@universal.edu.co','Ninon','442-273-5665','TI',3),
	 ('21-258-1049','esherbrookf@universal.edu.co','Elsbeth','993-932-8931','CC',4),
	 ('94-896-8987','jleeg@universal.edu.co','Joete','735-547-0419','TI',1),
	 ('21-068-1316','mpaylieh@universal.edu.co','Miriam','282-667-2072','CC',2),
	 ('22-991-5004','apittwoodi@universal.edu.co','Annissa','359-361-2885','TI',3),
	 ('49-187-5020','cmacmychemj@universal.edu.co','Chere','254-711-6097','CC',4);

INSERT INTO public.academic_program_students (academic_program_program_id,students_document) VALUES
	 (1,'82-965-6514'),
	 (2,'78-256-3500'),
	 (3,'96-406-0045'),
	 (4,'02-479-4831'),
	 (1,'96-989-8506'),
	 (2,'65-828-7410'),
	 (3,'08-099-0411'),
	 (4,'24-929-9124'),
	 (1,'17-285-7753'),
	 (2,'95-079-7574');
INSERT INTO public.academic_program_students (academic_program_program_id,students_document) VALUES
	 (3,'87-167-9521'),
	 (4,'47-571-1641'),
	 (1,'95-778-9851'),
	 (2,'75-941-0599'),
	 (3,'41-411-2619'),
	 (4,'21-258-1049'),
	 (1,'94-896-8987'),
	 (2,'21-068-1316'),
	 (3,'22-991-5004'),
	 (4,'49-187-5020');

INSERT INTO public.book (isbn,author,description,image,location_library,title,volume,available) VALUES
	 ('123-456-789','Dan Brown','','asdfasdf','CB-715','Inferno',1,true),
	 ('456-789-123','Edgar Allan Poe','','asdfasdf','ID-963','El cuervo',1,true),
	 ('789-456-123','Dante Alighieri','','asdfasdf','PD-159','La divina comedia',1,true),
	 ('789-123-369','Daniel Goleman','','asdfasdf','lk-139','Inteligencia emocional',1,true),
	 ('147-852-369','Len Bass','','asdfasdf','TU-795','Architecture in practice',1,true),
	 ('587-963-762','Solomon','','asdfasdf','GB-279','Biología',1,true);

INSERT INTO public.user_library (document,"password") VALUES
	 ('82-965-6514','sannis_123');

