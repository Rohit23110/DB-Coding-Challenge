INSERT INTO users (name, email, password, role) VALUES ('Rishi', 'rishikaul@gmail.com', '123456', 'customer'),
                                        ('Rohit', 'rohitpai@gmail.com', '123456', 'customer'),
                                        ('Richa', 'richasingh@gmail.com', '123456', 'customer'),
                                        ('Ranveer', 'ranveer@gmail.com', '123456', 'operation'),
                                        ('Rajat', 'rajat@gmail.com', '123456', 'operation');

INSERT INTO book (bookname) VALUES ('Government Bonds'), 
                                    ('Corporate Bonds'),
                                    ('Municipal Bonds');

INSERT INTO book_user (bookid, userid) VALUES (1, 1), 
                                              (2, 2),
                                              (3, 3),
                                              (1, 4),
                                              (2, 5);

INSERT INTO security (ISIN, CUSIP, issuer, maturitydate, coupon, type, facevalue, status) VALUES
                    ('AU0000XVGZA3', '987654321', 'Apple', '2022-02-01', 2.5, 'corporate', 100, 'Active' ),
                    ('BU0000YVGZB7', '876543219', 'Banana', '2019-08-21', 1.8, 'corporate', 50, 'Matured' ),
                    ('CD0000GVGZA1', '765432198', 'Maharashtra Government', '2022-01-01', 0.2, 'government', 10, 'Active' ),
                    ('AU0000XVGZA3', '654321987', 'Samsung', '2021-03-31', 3, 'corporate', 100, 'Matured' ),
                    ('AU000874FZA3', '638721987', 'Facebook', '2023-11-27', 3, 'corporate', 100, 'Active' ),
                    ('TU0000XVBFR3', '646321987', 'ElonsTwitter', '2022-10-31', 3, 'corporate', 100, 'Active' ),
                    ('AU0000XVGZA3', '543219876', 'BMC', '2019-05-10', 1.4, 'municipal', 250, 'Matured' );

INSERT INTO counterparty (name) VALUES ('Kirti'),
                                   ('Dhanshree'),
                                   ('Chandana'),
                                   ('Raunak'),
                                   ('Rishikesh');

-- sell -> false, buy -> true
INSERT INTO trade (bookid, userid, counterpartyid, securityid, quantity, status, price, buysell, tradedate, settlementdate) VALUES
                    (1, 3, 5, 2, 10, 'SETTLED', 270, false, '2019-02-11', '2019-02-12'),
                    (2, 4, 4, 3, 5, 'FAILED', 110, true, '2022-03-18', '2022-03-19'),
                    (2, 4, 4, 3, 5, 'FAILED', 110, false, '2022-04-21', '2022-04-23'),
                    (2, 4, 4, 3, 5, 'FAILED', 110, true, '2022-06-05', '2022-06-07'),
                    (3, 2, 3, 4, 75, 'SETTLED', 654, false, '2018-07-21', '2018-07-25'),
                    (1, 1, 2, 5, 40, 'SETTLED', 255, false, '2020-02-08', '2020-02-10'),
                    (2, 5, 1, 1, 37, 'SETTLED', 24, false, '2022-06-24', '2022-06-26'), -- wrong trade
                    (3, 2, 5, 2, 90, 'SETTLED', 789, false, '2019-06-30', '2019-07-03'); -- 

                    -- https://engpermits.lacity.org/bpermits/bond_section/common/status_definitions.htm