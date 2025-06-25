	CREATE DATABASE HotelBookingDB;
	USE HotelBookingDB;

	-- Create Table
	CREATE TABLE Customers (
		CustomerID INT AUTO_INCREMENT PRIMARY KEY,
		Name VARCHAR(100) NOT NULL,
		Country VARCHAR(50),
		Email VARCHAR(100) UNIQUE,
		LoyaltyPoints INT DEFAULT 0
	);

	CREATE TABLE Bookings (
		BookingID INT AUTO_INCREMENT PRIMARY KEY,
		CustomerID INT,
		RoomType VARCHAR(20) NOT NULL,
		BookingDate DATETIME DEFAULT CURRENT_TIMESTAMP,
		Nights INT,
		PaymentStatus VARCHAR(20) CHECK (PaymentStatus IN ('Paid', 'Pending')),
		FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
	);

	-- Insert Data
	INSERT INTO Customers (Name, Country, Email, LoyaltyPoints)
	VALUES ('Alice', 'USA', 'alice@example.com', 200),
		   ('Bob', 'India', 'bob@example.com', 150),
		   ('Nash','Australia','nash@gmail.com',0);

	INSERT INTO Bookings (CustomerID, RoomType, Nights, PaymentStatus)
	VALUES (1, 'Deluxe', 3, 'Paid'),
		   (2, 'Suite', 2, 'Pending'),
		   (1, 'Queen', 5, 'Pending'),
		   (3, 'Royal', 1, 'Paid');
		   
	SELECT * FROM Customers;
	SELECT * FROM Bookings;

	SELECT DISTINCT Country FROM Customers;
	SELECT * FROM Bookings WHERE PaymentStatus = 'Pending';
	SELECT Name, Email FROM Customers WHERE Country = 'India';
	SELECT * FROM Customers WHERE Country = 'USA' AND LoyaltyPoints > 100;
	SELECT * FROM Customers ORDER BY LoyaltyPoints DESC;

	UPDATE Customers SET LoyaltyPoints=100 WHERE CustomerID=2;

	INSERT INTO Bookings (CustomerID, RoomType, Nights, PaymentStatus)
	VALUES (2, 'Suite', 3, 'Paid');

	DELETE FROM Bookings WHERE BookingID=4;

	-- Malicious Code used by Injection
	SELECT * FROM Customers WHERE LoyaltyPoints<150 OR 1=1;

	SELECT TOP 2 * FROM Bookings;

	SELECT * FROM Customers WHERE Email LIKE 'a%@example.com';
	SELECT * FROM Customers WHERE Country IN ('USA', 'India');
	SELECT * FROM Bookings WHERE Nights BETWEEN 2 AND 4;
	SELECT Name AS CustomerName, Country AS Nationality FROM Customers;

	SELECT Customers.Name, Bookings.RoomType, Bookings.PaymentStatus
	FROM Customers
	INNER JOIN Bookings ON Customers.CustomerID = Bookings.CustomerID;

	SELECT Customers.Name, Bookings.RoomType
	FROM Customers
	LEFT JOIN Bookings ON Customers.CustomerID = Bookings.CustomerID;

	SELECT Customers.Name, Bookings.RoomType
	FROM Customers
	RIGHT JOIN Bookings ON Customers.CustomerID = Bookings.CustomerID;

	SELECT Customers.Name, Bookings.RoomType
	FROM Customers
	LEFT JOIN Bookings ON Customers.CustomerID = Bookings.CustomerID
	UNION
	SELECT Customers.Name, Bookings.RoomType
	FROM Customers
	RIGHT JOIN Bookings ON Customers.CustomerID = Bookings.CustomerID;

	SELECT Name FROM Customers
	UNION
	SELECT RoomType FROM Bookings;

	SELECT Name, Country INTO CustomerBackup FROM Customers;

	INSERT INTO Customers (Name, Country, Email, LoyaltyPoints)
	SELECT Name, Country, CONCAT(Name, '@backup.com'), 0 FROM CustomerBackup;

	ALTER TABLE Customers ADD Phone VARCHAR(15) NULL;
	ALTER TABLE Customers DROP COLUMN Phone;

	CREATE VIEW PaidBookings AS
	SELECT * FROM Bookings WHERE PaymentStatus = 'Paid';

	SELECT * FROM PaidBookings;

	SELECT Country, COUNT(*) AS CustomerCount FROM Customers GROUP BY Country;

	SELECT name, AVG(LoyaltyPoints) AS AvgPoints FROM Customers group by name having avg(LoyaltyPoints)>0;

	SELECT Name, ifnull(LoyaltyPoints, 120) as Points FROM Customers;

	PREPARE stmt FROM 'SELECT * FROM Customers WHERE Country = ?';
	SET @country = 'India';
	EXECUTE stmt USING @country;
	DEALLOCATE PREPARE stmt;

DELIMITER $$

CREATE PROCEDURE AddBooking (
    IN p_CustomerID INT,
    IN p_RoomType VARCHAR(20),
    IN p_Nights INT,
    IN p_PaymentStatus VARCHAR(20)
)
BEGIN
    INSERT INTO Bookings (CustomerID, RoomType, Nights, PaymentStatus)
    VALUES (p_CustomerID, p_RoomType, p_Nights, p_PaymentStatus);
END $$

DELIMITER ;


CALL AddBooking(3, 'Deluxe', 2, 'Pending');


-- Normalisation

-- Create Country Table
CREATE TABLE Countries (
    CountryID INT AUTO_INCREMENT PRIMARY KEY,
    CountryName VARCHAR(50) UNIQUE NOT NULL
);

INSERT INTO Countries (CountryName)
VALUES ('USA'), ('India'), ('Australia');

-- Create RoomTypes Table
CREATE TABLE RoomTypes (
    RoomTypeID INT AUTO_INCREMENT PRIMARY KEY,
    RoomTypeName VARCHAR(20) UNIQUE NOT NULL
);

INSERT INTO RoomTypes (RoomTypeName)
VALUES ('Deluxe'), ('Suite'), ('Queen'), ('Royal');

