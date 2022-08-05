

INSERT INTO users (id, name, email, password, role) VALUES (1, 'Rishi', 'rishikaul@gmail.com', '123456', 'customer'),
                                        (2, 'Rohit', 'rohitpai@gmail.com', '123456', 'customer'),
                                        (3, 'Richa', 'richasingh@gmail.com', '123456', 'customer'),
                                        (4, 'Ranveer', 'ranveer@gmail.com', '123456', 'operation'),
                                        (5, 'Rajat', 'rajat@gmail.com', '123456', 'operation');

INSERT INTO book (id, bookName) VALUES (1, 'Government Bonds'), 
                                    (2, 'Corporate Bonds'),
                                    (3, 'Municipal Bonds');

INSERT INTO book_user (bookId, userId) VALUES (1, 1), 
                                              (2, 2),
                                              (3, 3),
                                              (1, 4),
                                              (2, 5);

INSERT INTO security (id, ISIN, CUSIP, issuer, maturityDate, coupon, type, faceValue, status) VALUES
                    (1, 'AU0000XVGZA3', '987654321', 'Apple', '2004-02-01', 2.5, 'corporate', 100, 'ACTIVE' ),
                    (2, 'BU0000YVGZB7', '876543219', 'Banana', '2007-08-21', 1.8, 'corporate', 50, 'ACTIVE' ),
                    (3, 'CD0000GVGZA1', '765432198', 'Maharashtra Government', '2002-01-01', 0.2, 'government', 10, 'ACTIVE' ),
                    (4, 'AU0000XVGZA3', '654321987', 'Samsung', '2005-03-31', 3, 'corporate', 100, 'ACTIVE' ),
                    (5, 'AU0000XVGZA3', '543219876', 'BMC', '2009-05-10', 1.4, 'municipal', 250, 'ACTIVE' );

INSERT INTO counterparty (id, name) VALUES (1, 'Kirti'),
                                   (2, 'Dhanshree'),
                                   (3, 'Chandana'),
                                   (4, 'Raunak'),
                                   (5, 'Rishikesh');

                    -- https://engpermits.lacity.org/bpermits/bond_section/common/status_definitions.htm