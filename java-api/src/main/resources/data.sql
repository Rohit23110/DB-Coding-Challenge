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
                    ('AU0000XVGZA3', '987654321', 'Apple', '2004-02-01', 2.5, 'corporate', 100, 'ACTIVE' ),
                    ('BU0000YVGZB7', '876543219', 'Banana', '2007-08-21', 1.8, 'corporate', 50, 'ACTIVE' ),
                    ('CD0000GVGZA1', '765432198', 'Maharashtra Government', '2002-01-01', 0.2, 'government', 10, 'ACTIVE' ),
                    ('AU0000XVGZA3', '654321987', 'Samsung', '2005-03-31', 3, 'corporate', 100, 'ACTIVE' ),
                    ('AU0000XVGZA3', '543219876', 'BMC', '2009-05-10', 1.4, 'municipal', 250, 'ACTIVE' );

INSERT INTO counterparty (name) VALUES ('Kirti'),
                                   ('Dhanshree'),
                                   ('Chandana'),
                                   ('Raunak'),
                                   ('Rishikesh');

-- sell -> false, buy -> true
INSERT INTO trade (bookid, userid, counterpartyid, securityid, quantity, status, price, buysell, tradedate, settlementdate) VALUES
                    (1, 3, 5, 2, 3, 'SETTLED', 270, false, '2008-11-11', '2008-11-12')

                    -- https://engpermits.lacity.org/bpermits/bond_section/common/status_definitions.htm