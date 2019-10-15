-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 09, 2018 at 10:56 AM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Inventory_Control`
--

-- --------------------------------------------------------

--
-- Table structure for table `Adjustment`
--

CREATE TABLE `Adjustment` (
  `AdjustmentNo` varchar(50) NOT NULL,
  `ItemNo` varchar(50) DEFAULT '0',
  `Date` datetime DEFAULT NULL,
  `QtyOnHand` int(11) DEFAULT '0',
  `PhysicalCount` int(11) DEFAULT '0',
  `Adj+` int(11) DEFAULT '0',
  `Adj-` int(11) DEFAULT '0',
  `UpdatedQtyOnHand` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Carrier`
--

CREATE TABLE `Carrier` (
  `CarrierName` varchar(100) NOT NULL,
  `Phone` varchar(50) DEFAULT NULL,
  `Email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Category`
--

CREATE TABLE `Category` (
  `CategoryIndex` varchar(11) NOT NULL,
  `CategoryName` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Category`
--

INSERT INTO `Category` (`CategoryIndex`, `CategoryName`, `Description`) VALUES
('1', 'electronics', 'null'),
('100', 'Laundry', 'null');

-- --------------------------------------------------------

--
-- Table structure for table `City`
--

CREATE TABLE `City` (
  `Name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `City`
--

INSERT INTO `City` (`Name`) VALUES
('Ahero'),
('Awasi'),
('Bomet'),
('Bondo'),
('Bungoma'),
('Burnt Forest'),
('Busia'),
('Chuka'),
('Eldama Ravine'),
('Eldoret'),
('Embu'),
('Garissa'),
('Gilgil'),
('hika'),
('Homa Bay'),
('Isiolo'),
('Iten/Tambach'),
('Juja'),
('Kakamega'),
('Kakuma'),
('Kangundo-Tala'),
('Kapenguria'),
('Kapsabet'),
('Karuri'),
('Kehancha'),
('Kendu Bay'),
('Kericho'),
('Keroka'),
('Kerugoya/Kutus'),
('Kiambu'),
('Kikuyu'),
('Kilifi'),
('Kimilili'),
('Kipkelion'),
('Kisii'),
('Kisumu'),
('Kitale'),
('Kitengela'),
('Kitui'),
('Limuru'),
('Litein'),
('Lodwar'),
('Londiani'),
('Luanda'),
('Machakos'),
('Makuyu'),
('Malaba'),
('Malakisi'),
('Malava'),
('Malindi'),
('Mandera'),
('Maragua'),
('Maralal'),
('Mariakani'),
('Matuu'),
('Maua'),
('Mbita Point'),
('Meru'),
('Migori'),
('Molo'),
('Mombasa'),
('Moyale'),
('Mtwapa'),
('Muhoroni'),
('Mumias'),
('Mwingi'),
('Nairobi'),
('Nairobi Metro'),
('Naivasha'),
('Nakuru'),
('Nambale'),
('Nandi Hills'),
('Nanyuki'),
('Narok'),
('Ngong'),
('Nyahururu'),
('Nyamira'),
('Nyansiongo'),
('Nyeri'),
('Ogembo'),
('Ol Kalou'),
('Ongata Rongai'),
('Oyugis'),
('Rongo'),
('Ruiru'),
('Rumuruti'),
('Runyenjes'),
('Siaya'),
('Suneka'),
('Tabaka'),
('Taveta'),
('thi River (Mavoko)'),
('Ugunja'),
('Ukunda'),
('Ukwala'),
('Vihiga'),
('Voi'),
('Wajir'),
('Webuye'),
('Wundanyi'),
('Yala');

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
  `compname` varchar(255) NOT NULL,
  `compaddr` varchar(255) DEFAULT NULL,
  `comppan` varchar(255) DEFAULT NULL,
  `compddname` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`compname`, `compaddr`, `comppan`, `compddname`) VALUES
('MY Company', '189 Turkana', 'ABC101CDF9', 'Salama Group of Companies Pvt Ltd');

-- --------------------------------------------------------

--
-- Table structure for table `Country`
--

CREATE TABLE `Country` (
  `Name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Country`
--

INSERT INTO `Country` (`Name`) VALUES
('Afghanistan'),
('Albania'),
('Algeria'),
('American Samoa'),
('Andorra'),
('Angola'),
('Anguilla'),
('Antarctica'),
('Antigua and Barbuda'),
('Argentina'),
('Armenia'),
('Aruba'),
('Australia'),
('Austria'),
('Azerbaijan'),
('Bahamas'),
('Bahrain'),
('Bangladesh'),
('Barbados'),
('Belarus'),
('Belgium'),
('Belize'),
('Benin'),
('Bermuda'),
('Bhutan'),
('Bolivia'),
('Bosnia and Herzegovina'),
('Botswana'),
('Bouvet Island'),
('Brazil'),
('British Indian Ocean Territory'),
('Brunei Darussalam'),
('Bulgaria'),
('Burkina Faso'),
('Burundi'),
('Cambodia'),
('Cameroon'),
('Canada'),
('Cape Verde'),
('Cayman Islands'),
('Central African Republic'),
('Chad'),
('Chile'),
('China'),
('Christmas Island'),
('Cocos (Keeling) Islands'),
('Colombia'),
('Comoros'),
('Congo'),
('Cook Islands'),
('Costa Rica'),
('Cote D''Ivoire (Ivory Coast)'),
('Croatia (Hrvatska)'),
('Cuba'),
('Cyprus'),
('Czech Republic'),
('Denmark'),
('Djibouti'),
('Dominica'),
('Dominican Republic'),
('East Timor'),
('Ecuador'),
('Egypt'),
('El Salvador'),
('Equatorial Guinea'),
('Eritrea'),
('Estonia'),
('Ethiopia'),
('Falkland Islands (Malvinas)'),
('Faroe Islands'),
('Fiji'),
('Finland'),
('France'),
('France, Metropolitan'),
('French Guiana'),
('French Polynesia'),
('French Southern Territories'),
('Gabon'),
('Gambia'),
('Georgia'),
('Germany'),
('Ghana'),
('Gibraltar'),
('Great Britain (UK)'),
('Greece'),
('Greenland'),
('Grenada'),
('Guadeloupe'),
('Guam'),
('Guatemala'),
('Guinea'),
('Guinea-Bissau'),
('Guyana'),
('Haiti'),
('Heard and McDonald Islands'),
('Honduras'),
('Hong Kong'),
('Hungary'),
('Iceland'),
('India'),
('Indonesia'),
('Iran'),
('Iraq'),
('Ireland'),
('Israel'),
('Italy'),
('Jamaica'),
('Japan'),
('Jordan'),
('Kazakhstan'),
('Kenya'),
('Kiribati'),
('Korea (North)'),
('Korea (South)'),
('Kuwait'),
('Kyrgyzstan'),
('Laos'),
('Latvia'),
('Lebanon'),
('Lesotho'),
('Liberia'),
('Libya'),
('Liechtenstein'),
('Lithuania'),
('Luxembourg'),
('Macau'),
('Macedonia'),
('Madagascar'),
('Malawi'),
('Malaysia'),
('Maldives'),
('Mali'),
('Malta'),
('Marshall Islands'),
('Martinique'),
('Mauritania'),
('Mauritius'),
('Mayotte'),
('Mexico'),
('Micronesia'),
('Moldova'),
('Monaco'),
('Mongolia'),
('Montserrat'),
('Morocco'),
('Mozambique'),
('Myanmar'),
('Namibia'),
('Nauru'),
('Nepal'),
('Netherlands'),
('Netherlands Antilles'),
('Neutral Zone'),
('New Caledonia'),
('New Zealand (Aotearoa)'),
('Nicaragua'),
('Niger'),
('Nigeria'),
('Niue'),
('Norfolk Island'),
('Northern Mariana Islands'),
('Norway'),
('Oman'),
('Pakistan'),
('Palau'),
('Panama'),
('Papua New Guinea'),
('Paraguay'),
('Peru'),
('Philippines'),
('Pitcairn'),
('Poland'),
('Portugal'),
('Puerto Rico'),
('Qatar'),
('Reunion'),
('Romania'),
('Russian Federation'),
('Rwanda'),
('S. Georgia and S. Sandwich Isls'),
('Saint Kitts and Nevis'),
('Saint Lucia'),
('Samoa'),
('San Marino'),
('Sao Tome and Principe'),
('Saudi Arabia'),
('Senegal'),
('Seychelles'),
('Sierra Leone'),
('Singapore'),
('Slovak Republic'),
('Slovenia'),
('Solomon Islands'),
('Somalia'),
('South Africa'),
('Spain'),
('Sri Lanka'),
('St. Helena'),
('St. Pierre and Miquelon'),
('St. Vincent and the Grenadines'),
('Sudan'),
('Suriname'),
('Svalbard and Jan Mayen Islands'),
('Swaziland'),
('Sweden'),
('Switzerland'),
('Syria'),
('Taiwan'),
('Tajikistan'),
('Tanzania'),
('Thailand'),
('Togo'),
('Tokelau'),
('Tonga'),
('Trinidad and Tobago'),
('Tunisia'),
('Turkey'),
('Turkmenistan'),
('Turks and Caicos Islands'),
('Tuvalu'),
('Uganda'),
('Ukraine'),
('United Arab Emirates'),
('United Kingdom'),
('United States'),
('Uruguay'),
('US Minor Outlying Islands'),
('Uzbekistan'),
('Vanuatu'),
('Vatican City State (Holy See)'),
('Venezuela'),
('Viet Nam'),
('Virgin Islands (British)'),
('Virgin Islands (U.S.)'),
('Wallis and Futuna Islands'),
('Western Sahara'),
('Yemen'),
('Yugoslavia'),
('Zaire'),
('Zambia'),
('Zimbabwe');

-- --------------------------------------------------------

--
-- Table structure for table `county`
--

CREATE TABLE `county` (
  `Name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `county`
--

INSERT INTO `county` (`Name`) VALUES
('\r\nBaringo'),
('\r\nBomet'),
('\r\nBungoma'),
('\r\nBusia'),
('\r\nElgeyo-Marakwet'),
('\r\nEmbu'),
('\r\nGarissa'),
('\r\nHoma Bay'),
('\r\nIsiolo'),
('\r\nKajiado'),
('\r\nKakamega'),
('\r\nKericho'),
('\r\nKiambu'),
('\r\nKilifi'),
('\r\nKirinyaga'),
('\r\nKisii'),
('\r\nKisumu'),
('\r\nKitui'),
('\r\nKwale'),
('\r\nLaikipia'),
('\r\nLamu'),
('\r\nMachakos'),
('\r\nMakueni'),
('\r\nMandera'),
('\r\nMarsabit'),
('\r\nMeru'),
('\r\nMigori'),
('\r\nMuranga'),
('\r\nNairobi City'),
('\r\nNakuru'),
('\r\nNandi'),
('\r\nNarok'),
('\r\nNyamira'),
('\r\nNyandarua'),
('\r\nNyeri'),
('\r\nSamburu'),
('\r\nSiaya'),
('\r\nTaita-Taveta'),
('\r\nTana River'),
('\r\nTharaka-Nithi'),
('\r\nTrans Nzoia'),
('\r\nTurkana'),
('\r\nUasin Gishu'),
('\r\nVihiga'),
('\r\nwajir'),
('\r\nWest Pokot'),
('County\r\nMombasa');

-- --------------------------------------------------------

--
-- Table structure for table `Customer`
--

CREATE TABLE `Customer` (
  `CustomerID` varchar(50) NOT NULL,
  `CompanyName` varchar(255) DEFAULT NULL,
  `ContactName` varchar(255) DEFAULT NULL,
  `ContactTitle` varchar(50) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `CityTown` varchar(255) DEFAULT NULL,
  `county` varchar(255) DEFAULT NULL,
  `boxno` varchar(50) DEFAULT NULL,
  `Country` varchar(100) DEFAULT NULL,
  `Phone` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Customer`
--

INSERT INTO `Customer` (`CustomerID`, `CompanyName`, `ContactName`, `ContactTitle`, `Email`, `CityTown`, `county`, `boxno`, `Country`, `Phone`) VALUES
('011', 'dd', 'fd', 'fd', 'fd', 'fdgf', 'dfgd', 'dfg', 'Afghanistan', '12344'),
('100', 'richard', 'ndemo', 'headofficer', 'ndemo@gmail.com', 'kitale', 'transnzoia', '432', 'Afghanistan', '454545'),
('101', 'jane', 'jane2', 'hr', 'jane@gmail.com', 'eldoret', 'uasin gishu', '1892', 'Kenya', '071489033'),
('4344', 'f', 'df', '', '', '', '', '', 'Afghanistan', ''),
('99', 'rebeca', 'rebecca', 'hr', 'rebeca@gmail.com', 'nakuru', 'nakuru', 'rebeca@gmail.com', 'Afghanistan', '071489678372');

-- --------------------------------------------------------

--
-- Table structure for table `Employee`
--

CREATE TABLE `Employee` (
  `EmployeeID` varchar(30) NOT NULL,
  `Title` varchar(30) NOT NULL,
  `First_name` varchar(30) NOT NULL,
  `Last_name` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Phone` varchar(30) NOT NULL,
  `Employee_ID_no` varchar(30) NOT NULL,
  `Gender` varchar(30) NOT NULL,
  `DOB` varchar(30) NOT NULL,
  `password` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Employee`
--

INSERT INTO `Employee` (`EmployeeID`, `Title`, `First_name`, `Last_name`, `Email`, `Phone`, `Employee_ID_no`, `Gender`, `DOB`, `password`) VALUES
('100', 'mr', 'richard', 'ndemo', 'ndemorich@gmail.com', '0714906854', '33344566', 'male', '1990', 'ndemo'),
('12', 'mr', 'nyakoria', 'joash', 'nyakoria@gmail.com', '323', '232', 'male', '565', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `Expense`
--

CREATE TABLE `Expense` (
  `ExpenseIndex` int(11) NOT NULL,
  `ExpenseNo` varchar(100) DEFAULT NULL,
  `Purpose` varchar(255) DEFAULT NULL,
  `payment_Date` date NOT NULL,
  `payment_method` varchar(30) NOT NULL,
  `ApprovedBy` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Invoices`
--

CREATE TABLE `Invoices` (
  `InvoiceID` varchar(30) NOT NULL,
  `Client` varchar(30) NOT NULL,
  `Invoice_date` varchar(30) NOT NULL,
  `Due_date` varchar(30) NOT NULL,
  `partial_depo` varchar(30) NOT NULL,
  `POID` varchar(30) NOT NULL,
  `Discount` varchar(30) NOT NULL,
  `Item` varchar(30) NOT NULL,
  `Description` varchar(30) NOT NULL,
  `Unit_cost` varchar(30) NOT NULL,
  `Quantity` varchar(30) NOT NULL,
  `Line_total` varchar(30) NOT NULL,
  `Subtotal` varchar(30) NOT NULL,
  `Paid_to_date` varchar(30) NOT NULL,
  `Balance_due` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Invoices`
--

INSERT INTO `Invoices` (`InvoiceID`, `Client`, `Invoice_date`, `Due_date`, `partial_depo`, `POID`, `Discount`, `Item`, `Description`, `Unit_cost`, `Quantity`, `Line_total`, `Subtotal`, `Paid_to_date`, `Balance_due`) VALUES
('IC8UFYX6', 'dd', '2018-07-03', '2018-07-03', 'fff', '100', 'dff', 'soap', 'fdf', 'df', 'ff', 'fr', 'g', '2018-07-03', 'dfd'),
('MGAF0G1Z', 'dd', '2018-07-03', '2018-07-03', 'df', '100', 'fdf', 'soap', 'fdf', 'dd', 'fd', 'fdf', 'fdf', '2018-07-03', 'fv'),
('1CW0D5851', 'dd', '2018-07-03', '2018-07-03', 'ee', '100', 'ee', 'soap', 'ee', 'ee', 'eee', 'ee', 'ee', '2018-07-03', 're'),
('1D3NKYZ1N', 'dd', '2018-07-03', '2018-07-03', 'ee', '100', 'ee', 'soap', 'ee', 'ee', 'eee', 'ee', 'ee', '2018-07-03', 're'),
('1EYJUHKY8', 'dd', '2018-07-03', '2018-07-03', 'ee', '100', 'ee', 'soap', 'ee', 'ee', 'eee', 'ee', 'ee', '2018-07-03', 're'),
('1JG62Q9PV', 'dd', '2018-07-03', '2018-07-03', 'dfhd', '100', 'dfh', 'soap', 'dh', 'hdfhdf', 'dh', 'dh', 'dhd', '2018-07-03', 'dgd'),
('2I5SSQWS7', 'dd', '2018-07-03', '2018-07-03', 'sdfs', '100', 'sdf', 'soap', 'sdfsd', 'sdsd', 'sdfsd', 'sdf', 'dsfsd', '2018-07-03', 'fssf'),
('2IJFKJJSE', 'dd', '2018-07-03', '2018-07-03', 'sdfs', '100', 'sdf', 'soap', 'sdfsd', 'sdsd', 'sdfsd', 'sdf', 'dsfsd', '2018-07-03', 'fssf'),
('332VXKZ50', 'dd', '2018-07-03', '2018-07-03', 'sd', '100', 'dsd', 'soap', 'dsd', 'ds', 'sd', 'dsd', 'ds', '2018-07-03', 'sd'),
('6UCC0KSB', 'richard', '2018-07-03', '2018-07-03', 'fdf', '100', 'df', 'soap', 'fdf', 'dd', 'fdf', 'df', 'df', '2018-07-03', '123'),
('CHKHBBPL', 'richard', '2018-07-03', '2018-07-03', 'fdf', '100', 'df', 'soap', 'fdf', 'dd', 'fdf', 'df', 'df', '2018-07-03', '123'),
('DGW4SY9U', 'richard', '2018-07-03', '2018-07-03', 'bb', '100', 'gg', 'soap', 'ggg', 'ffg', 'bb', 'bb', 'bb', '2018-07-03', 'redf'),
('VXNYBDAU', 'jane', '2018-07-03', '2018-07-03', 'rrf', '100', 'ff', 'soap', 'ff', 'ff', 'ff', 'ff', 'fff', '2018-07-03', 'ggg'),
('YE1712IO', 'richard', '2018-07-03', '2018-07-03', 'ww', '100', 'rr', 'soap', 'rr', 'rrr', 'ww', 'ww', 'ww', '2018-07-03', 'trrff'),
('110C0O5FA', 'richard', '2018-07-03', '2018-07-03', 'ggg', '100', 'ggg', 'soap', 'ddd', 'ddd', 'ggg', 'ggg', 'gg', '2018-07-03', 'rdd'),
('1700EOIFO', 'richard', '2018-07-03', '2018-07-03', 'sd', '100', 'dds', 'soap', 'sd', 'dsd', 'dsd', 'sd', 'sd', '2018-07-03', 'ds'),
('1BMIO273H', 'dd', '2018-07-03', '2018-07-03', 'dfd', '100', 'df', 'soap', 'fdf', 'fdf', 'fdf', 'fdf', 'df', '2018-07-03', 'sff'),
('85U4ZW84', 'richard', '2018-07-03', '2018-07-03', 'fdf', '100', 'dff', 'soap', 'dff', 'df', 'df', 'df', 'df', '2018-07-03', 'df'),
('AI5UNNHA', 'dd', '2018-03-04', '2018-07-03', 'uyu', '100', 'uy', 'soap', 'yu', 'uy', 'yu', 'yu', 'uy', '2018-07-03', 'yu'),
('G60LHO5K', 'dd', '2018-03-03', '2018-03-02', 'er', '100', 'ds', 'soap', 'd', 'd', 'r', 'sd', 'ds', '2018-04-03', 'erg'),
('GXK384T83', 'dd', '2012-02-03', '2015-05-05', 'thgf', '100', 'hgfh', 'soap', '1002', 'hgfdg', 'mg', 'hj', 'ghfhgv', '2014-03-04', 'dht'),
('XR0HLPX5', 'dd', '2018-08-01', '2018-03-02', '11', '100', '11', 'soap', '1002', '11', '11', '11', '11', '2018-03-04', '33'),
('3CONUN71O', 'dd', '0000-00-00', '0000-00-00', '3', '100', '3', 'soap', '1002', '3', '3', '3', '3', '0000-00-00', '3'),
('3CRK9N4FC', 'dd', '0000-00-00', '0000-00-00', '3', '100', '3', 'soap', '1002', '3', '3', '3', '3', '0000-00-00', '3'),
('3E9865XLV', 'dd', '0000-00-00', '0000-00-00', '1', '100', '11', 'soap', '1002', '11', '1', '1', '1', '0000-00-00', '11'),
('3V03MQLEZ', 'dd', 'Sun Dec 31 00:00:00 EAT 2017', 'Sun Dec 31 00:00:00 EAT 2017', '1', 'dfd', '1', 'soap', '1002', '1', '1', '1', '1', 'Sun Dec 31 12:12:15 EAT 2017', '1'),
('24NK7X6ED', 'dd', 'Sun Dec 31 11:59:22 EAT 2017', 'Sun Dec 31 00:00:00 EAT 2017', '33', '100', '3', 'soap', '1002', '3', '3', '3', '3', 'Sun Dec 31 11:59:27 EAT 2017', '33'),
('2H87D7T8L', 'dd', 'Sun Dec 31 12:15:49 EAT 2017', 'Sun Dec 31 12:15:58 EAT 2017', '2', '100', '2', 'soap', '1002', '2', '2', '2', '2', 'Sun Dec 31 00:00:00 EAT 2017', '3'),
('3ESQZFV1G', 'dd', '2018.59.04', '2018.59.04', 'efr', '100', 'ff', 'soap', '1002', 'fff', 'ff', 'ff', 'ff', '2018.59.04', 'ff'),
('3J3EHR152', 'richard', '2018.05.04', '2018.05.04', '555', '100', '55', 'soap', '1002', '55', '55', '55', '55', '2018.05.04', '55'),
('ABXLGHAHT', 'dd', '2018.24.04', '2018.24.04', '2', '100', '2', 'soap', '1002', '2', '2', '2', '2', '2018.24.04', '2'),
('15HLMFT3F', 'dd', '2018.38.05', '2018.38.05', '2', '100', '2', 'soap', '1002', '2', '2', '2', '2', '2018.38.05', '2'),
('1C0U3WYCO', 'dd', '2018.46.05', '2018.46.05', '2', '100', '2', 'soap', '1002', '2', '2', '2', '2', '2018.46.05', '2');

-- --------------------------------------------------------

--
-- Table structure for table `Item`
--

CREATE TABLE `Item` (
  `ItemNo` varchar(50) NOT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `SKU` varchar(30) DEFAULT NULL,
  `CategoryIndex` varchar(11) DEFAULT '0',
  `SupplierId` varchar(50) DEFAULT '0',
  `QuantityPerUnit` varchar(100) DEFAULT NULL,
  `UnitMeasure` varchar(100) DEFAULT NULL,
  `UnitCost` double DEFAULT '0',
  `SalesPrice` double DEFAULT '0',
  `QtyOnHand` int(11) DEFAULT '0',
  `QtyOnOrder` int(11) DEFAULT '0',
  `ReOrderLevel` int(11) DEFAULT '0',
  `WarehouseId` varchar(11) DEFAULT '0',
  `Location` varchar(100) DEFAULT NULL,
  `Active` varchar(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Item`
--

INSERT INTO `Item` (`ItemNo`, `Description`, `SKU`, `CategoryIndex`, `SupplierId`, `QuantityPerUnit`, `UnitMeasure`, `UnitCost`, `SalesPrice`, `QtyOnHand`, `QtyOnOrder`, `ReOrderLevel`, `WarehouseId`, `Location`, `Active`) VALUES
('100', 'soap', '1002', '123', '4343', 'dfd', 'dfd', 11, 11, 11, 11, 33, '343', 'vdfv', '11');

-- --------------------------------------------------------

--
-- Table structure for table `PO`
--

CREATE TABLE `PO` (
  `PONo` varchar(50) NOT NULL,
  `Date` varchar(30) DEFAULT NULL,
  `SupplierID` varchar(11) DEFAULT NULL,
  `ShipFromAddress` varchar(255) DEFAULT NULL,
  `ShipFromCounty` varchar(255) DEFAULT NULL,
  `ShipViaCarrierName` varchar(11) DEFAULT NULL,
  `ShippingFee` varchar(30) DEFAULT NULL,
  `Others` varchar(20) DEFAULT NULL,
  `ApprovedBy` varchar(255) DEFAULT NULL,
  `ItemNo` varchar(30) NOT NULL,
  `Description` varchar(30) NOT NULL,
  `QtyPurchased` varchar(30) NOT NULL,
  `UnitCost` varchar(30) DEFAULT NULL,
  `Discount` varchar(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `PO`
--

INSERT INTO `PO` (`PONo`, `Date`, `SupplierID`, `ShipFromAddress`, `ShipFromCounty`, `ShipViaCarrierName`, `ShippingFee`, `Others`, `ApprovedBy`, `ItemNo`, `Description`, `QtyPurchased`, `UnitCost`, `Discount`) VALUES
('fd', '2018-07-03', 'dfd', 'df', 'df', 'fd', 'df', 'df', 'df', 'df', 'df', 'df', 'fd', 'df'),
('dfd', '2018-07-03', 'fd', 'dfd', 'dfd', 'dfdf', 'dfdf', 'dfd', 'dfd', 'dfdf', 'dfdf', 'dfd', 'dfd', 'dfd'),
('100', '2018-07-03', '100', '100', 'kenya', 'g4s', '1000', 'red', 'richard', '12', 'cup', '1', '12', 'rr'),
('re', ' YYY-MM-dd', 'er', 'er', 'e', 'fer', 'erf', 'er', 'erf', 'efe', 'erf', 'erf', 'ef', 'erf'),
('123', ' YYY-MM-dd', '22', '222', 'gf', 'gf', 't', 'rtr', 'rt', '22', 'ere', '34', '43', '434');

-- --------------------------------------------------------

--
-- Table structure for table `PR`
--

CREATE TABLE `PR` (
  `PRNo` varchar(11) NOT NULL,
  `SupplierID` varchar(30) NOT NULL,
  `ItemNo` varchar(11) DEFAULT NULL,
  `Description` varchar(30) NOT NULL,
  `QtyRecieve` varchar(11) DEFAULT NULL,
  `UnitCost` varchar(30) DEFAULT NULL,
  `PONo` varchar(30) NOT NULL,
  `DateRecieve` varchar(30) NOT NULL,
  `Totalamount` varchar(30) NOT NULL,
  `ApprovedBy` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `PR`
--

INSERT INTO `PR` (`PRNo`, `SupplierID`, `ItemNo`, `Description`, `QtyRecieve`, `UnitCost`, `PONo`, `DateRecieve`, `Totalamount`, `ApprovedBy`) VALUES
('100', '200', '43', 'unga', '3', '23', '343', '234/543', '32', '23'),
('aed', 'ad', 'asd', 'asda', 'asda', 'asda', 'asda', 'asd', 'asda', 'asda'),
('rw', 'ewer', 'ewrw', 'werw', 'wer', 'wer', 'wer', 'wer', 'wer', 'wer');

-- --------------------------------------------------------

--
-- Table structure for table `Supplier`
--

CREATE TABLE `Supplier` (
  `SupplierID` varchar(30) NOT NULL,
  `Title` varchar(30) NOT NULL,
  `First_name` varchar(30) NOT NULL,
  `Middle_name` varchar(30) NOT NULL,
  `Last_name` varchar(30) NOT NULL,
  `Display_name_as` varchar(30) NOT NULL,
  `Phone` varchar(30) NOT NULL,
  `Company_name` varchar(100) NOT NULL,
  `Busines_ID_no` varchar(100) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Country` varchar(30) NOT NULL,
  `County` varchar(30) NOT NULL,
  `website` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Supplier`
--

INSERT INTO `Supplier` (`SupplierID`, `Title`, `First_name`, `Middle_name`, `Last_name`, `Display_name_as`, `Phone`, `Company_name`, `Busines_ID_no`, `Email`, `Country`, `County`, `website`) VALUES
('100', 'mr', 'john', 'munya', 'munyaa', 'mugea', '0714906854', 'bricklebry', '34567', 'john@gmail.com', 'Kenya', 'transmara', 'www.john.com');

-- --------------------------------------------------------

--
-- Table structure for table `Warehouse`
--

CREATE TABLE `Warehouse` (
  `WarehouseID` varchar(50) NOT NULL,
  `WarehouseName` varchar(255) DEFAULT NULL,
  `ContactPerson` varchar(255) DEFAULT NULL,
  `ContactTitle` varchar(100) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `CityTown` varchar(255) DEFAULT NULL,
  `county` varchar(255) DEFAULT NULL,
  `boxno` varchar(50) DEFAULT NULL,
  `Phone` varchar(50) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Warehouse`
--

INSERT INTO `Warehouse` (`WarehouseID`, `WarehouseName`, `ContactPerson`, `ContactTitle`, `Address`, `CityTown`, `county`, `boxno`, `Phone`, `Email`) VALUES
('001', 'tt', 'fdf', 'df', 'df', 'df', 'df', 'df', 'df', 'dfg'),
('99', 'godown', 'dww', 'dwdw', 'wwew', 'wewe', 'wewe', 'wewe', 'wew', 'ww');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Adjustment`
--
ALTER TABLE `Adjustment`
  ADD PRIMARY KEY (`AdjustmentNo`),
  ADD KEY `ItemNo` (`ItemNo`);

--
-- Indexes for table `Carrier`
--
ALTER TABLE `Carrier`
  ADD PRIMARY KEY (`CarrierName`);

--
-- Indexes for table `Category`
--
ALTER TABLE `Category`
  ADD PRIMARY KEY (`CategoryIndex`);

--
-- Indexes for table `City`
--
ALTER TABLE `City`
  ADD PRIMARY KEY (`Name`);

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`compname`);

--
-- Indexes for table `Country`
--
ALTER TABLE `Country`
  ADD PRIMARY KEY (`Name`);

--
-- Indexes for table `county`
--
ALTER TABLE `county`
  ADD PRIMARY KEY (`Name`);

--
-- Indexes for table `Customer`
--
ALTER TABLE `Customer`
  ADD PRIMARY KEY (`CustomerID`),
  ADD KEY `Country` (`Country`);

--
-- Indexes for table `Employee`
--
ALTER TABLE `Employee`
  ADD PRIMARY KEY (`EmployeeID`);

--
-- Indexes for table `Expense`
--
ALTER TABLE `Expense`
  ADD PRIMARY KEY (`ExpenseIndex`),
  ADD KEY `ExpenseNo` (`ExpenseNo`);

--
-- Indexes for table `Item`
--
ALTER TABLE `Item`
  ADD PRIMARY KEY (`ItemNo`),
  ADD KEY `SupplierId` (`SupplierId`),
  ADD KEY `WarehouseId` (`WarehouseId`),
  ADD KEY `CategoryIndex` (`CategoryIndex`);

--
-- Indexes for table `PO`
--
ALTER TABLE `PO`
  ADD PRIMARY KEY (`PONo`);

--
-- Indexes for table `PR`
--
ALTER TABLE `PR`
  ADD PRIMARY KEY (`PRNo`);

--
-- Indexes for table `Supplier`
--
ALTER TABLE `Supplier`
  ADD PRIMARY KEY (`SupplierID`);

--
-- Indexes for table `Warehouse`
--
ALTER TABLE `Warehouse`
  ADD PRIMARY KEY (`WarehouseID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Expense`
--
ALTER TABLE `Expense`
  MODIFY `ExpenseIndex` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
