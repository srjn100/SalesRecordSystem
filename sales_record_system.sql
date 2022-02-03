-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 03, 2022 at 11:45 AM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sales_record_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `category_id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`category_id`, `name`) VALUES
(2, 'Biscuit'),
(1, 'Cooking Oil'),
(3, 'Noodles');

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `customer_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone` bigint(20) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customer_id`, `name`, `address`, `phone`, `email`) VALUES
(1, 'abc mart', 'bkt', 9876543110, 'abcm@gmail.com'),
(3, 'ktm store', 'ktm', 9807004321, 'ktmstore@ymail.com'),
(4, 'xyz store', 'bkt', 9473464235, 'xyz@gmail.com'),
(5, 'bg store', 'kavre', 9786656546, 'bgstore@gmail.com'),
(6, 'shiv mart', 'koteshwor', 9854333333, 'smart@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `payment_id` int(11) NOT NULL,
  `purchase_id` int(11) DEFAULT NULL,
  `sales_id` int(11) DEFAULT NULL,
  `amount` double NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp(),
  `cheque_num` int(11) DEFAULT NULL,
  `updated_by` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`payment_id`, `purchase_id`, `sales_id`, `amount`, `date`, `cheque_num`, `updated_by`) VALUES
(1, 1, NULL, 100000, '2021-10-04', NULL, 1),
(2, 2, NULL, 10000, '2021-10-04', NULL, 1),
(3, NULL, 1, 1800, '2021-10-04', NULL, 1),
(4, NULL, 2, 10000, '2021-10-04', NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `product_id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `description` varchar(100) NOT NULL,
  `sales_price` double NOT NULL,
  `category_id` int(11) NOT NULL,
  `updated_by` int(11) NOT NULL,
  `updated_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`product_id`, `name`, `description`, `sales_price`, `category_id`, `updated_by`, `updated_date`) VALUES
(1, 'digestive', '100 gram', 342, 2, 1, '2021-10-03 22:22:59'),
(2, 'shakti soyabean oil', '1 liter', 280, 1, 1, '2021-10-03 22:25:51'),
(3, 'Byanjan soyabean oil', '500 ml', 180, 1, 1, '2021-10-03 22:26:44'),
(4, 'marie', '50 gram', 344, 2, 1, '2021-10-03 22:23:57'),
(7, 'monaco', '50 gram', 112, 2, 1, '2021-10-03 22:24:35'),
(8, 'shakti sunflower oil', '1 liter', 400, 1, 1, '2021-10-03 22:27:36');

-- --------------------------------------------------------

--
-- Table structure for table `purchased_items`
--

CREATE TABLE `purchased_items` (
  `purchased_item_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `purchase_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `purchase_price` double NOT NULL,
  `mfg_date` date NOT NULL,
  `exp_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `purchased_items`
--

INSERT INTO `purchased_items` (`purchased_item_id`, `product_id`, `purchase_id`, `quantity`, `purchase_price`, `mfg_date`, `exp_date`) VALUES
(1, 2, 1, 300, 250, '2021-05-01', '2022-05-01'),
(2, 3, 1, 300, 150, '2021-04-01', '2022-04-01'),
(3, 7, 2, 100, 100, '2020-12-30', '2021-12-30');

-- --------------------------------------------------------

--
-- Table structure for table `purchases`
--

CREATE TABLE `purchases` (
  `purchase_id` int(11) NOT NULL,
  `payment_status` tinyint(1) NOT NULL,
  `purchase_date` date NOT NULL DEFAULT current_timestamp(),
  `discount` double DEFAULT NULL,
  `supplier_id` int(11) NOT NULL,
  `updated_by` int(11) NOT NULL,
  `updated_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `purchases`
--

INSERT INTO `purchases` (`purchase_id`, `payment_status`, `purchase_date`, `discount`, `supplier_id`, `updated_by`, `updated_date`) VALUES
(1, 0, '2021-10-04', NULL, 2, 1, '2021-10-03 22:42:05'),
(2, 1, '2021-10-04', NULL, 4, 1, '2021-10-03 23:00:55');

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `sales_id` int(11) NOT NULL,
  `payment_status` tinyint(1) NOT NULL,
  `sales_date` date NOT NULL DEFAULT current_timestamp(),
  `discount` double DEFAULT NULL,
  `customer_id` int(11) NOT NULL,
  `updated_by` int(11) NOT NULL,
  `updated_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`sales_id`, `payment_status`, `sales_date`, `discount`, `customer_id`, `updated_by`, `updated_date`) VALUES
(1, 1, '2021-10-04', 0, 3, 1, '2021-10-04 01:18:13'),
(2, 0, '2021-10-04', 0, 5, 1, '2021-10-04 01:40:53');

-- --------------------------------------------------------

--
-- Table structure for table `sales_items`
--

CREATE TABLE `sales_items` (
  `sales_item_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `sales_id` int(11) NOT NULL,
  `stock_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `sales_price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sales_items`
--

INSERT INTO `sales_items` (`sales_item_id`, `product_id`, `sales_id`, `stock_id`, `quantity`, `sales_price`) VALUES
(1, 3, 1, 2, 10, 180),
(2, 2, 2, 1, 40, 280),
(3, 3, 2, 2, 20, 180);

-- --------------------------------------------------------

--
-- Table structure for table `stocks`
--

CREATE TABLE `stocks` (
  `stock_id` int(11) NOT NULL,
  `purchased_item_id` int(11) NOT NULL,
  `available_qty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stocks`
--

INSERT INTO `stocks` (`stock_id`, `purchased_item_id`, `available_qty`) VALUES
(1, 1, 260),
(2, 2, 270),
(3, 3, 100);

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE `suppliers` (
  `supplier_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone` bigint(20) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `suppliers`
--

INSERT INTO `suppliers` (`supplier_id`, `name`, `address`, `phone`, `email`) VALUES
(1, 'super suppliers', 'ktm', 97543981183, 'sup@gmail.com'),
(2, 'himal marketer', 'bkt', 93746555764, 'him11@gmail.com'),
(3, 'ktm marketers', 'ktm', 965658723, 'sddsaf@gmail.com'),
(4, 'ambe traders', 'kavre', 98776872011, 'amb@gmail.com'),
(5, 'abc ', 'fyft', 987654234, 'hjh@hh.hh');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(32) NOT NULL,
  `full_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` bigint(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `isActive` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`, `full_name`, `email`, `phone`, `address`, `isActive`) VALUES
(1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin', 'admin@gmail.com', 9876543210, 'bhaktapur', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`category_id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`customer_id`),
  ADD UNIQUE KEY `phone` (`phone`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`payment_id`),
  ADD KEY `purchase_id` (`purchase_id`),
  ADD KEY `updated_by` (`updated_by`),
  ADD KEY `sales_id` (`sales_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `updated_by` (`updated_by`),
  ADD KEY `category_id` (`category_id`);

--
-- Indexes for table `purchased_items`
--
ALTER TABLE `purchased_items`
  ADD PRIMARY KEY (`purchased_item_id`),
  ADD KEY `product_id` (`product_id`),
  ADD KEY `purchase_id` (`purchase_id`);

--
-- Indexes for table `purchases`
--
ALTER TABLE `purchases`
  ADD PRIMARY KEY (`purchase_id`),
  ADD KEY `supplier_id` (`supplier_id`),
  ADD KEY `updated_by` (`updated_by`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`sales_id`),
  ADD KEY `customer_id` (`customer_id`),
  ADD KEY `updated_by` (`updated_by`);

--
-- Indexes for table `sales_items`
--
ALTER TABLE `sales_items`
  ADD PRIMARY KEY (`sales_item_id`),
  ADD KEY `product_id` (`product_id`),
  ADD KEY `sales_id` (`sales_id`),
  ADD KEY `stock_id` (`stock_id`);

--
-- Indexes for table `stocks`
--
ALTER TABLE `stocks`
  ADD PRIMARY KEY (`stock_id`),
  ADD KEY `purchased_item_id` (`purchased_item_id`);

--
-- Indexes for table `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`supplier_id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `phone` (`phone`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `phone` (`phone`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `purchased_items`
--
ALTER TABLE `purchased_items`
  MODIFY `purchased_item_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `purchases`
--
ALTER TABLE `purchases`
  MODIFY `purchase_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `sales_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `sales_items`
--
ALTER TABLE `sales_items`
  MODIFY `sales_item_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `stocks`
--
ALTER TABLE `stocks`
  MODIFY `stock_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `suppliers`
--
ALTER TABLE `suppliers`
  MODIFY `supplier_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `payments`
--
ALTER TABLE `payments`
  ADD CONSTRAINT `payments_ibfk_1` FOREIGN KEY (`purchase_id`) REFERENCES `purchases` (`purchase_id`),
  ADD CONSTRAINT `payments_ibfk_2` FOREIGN KEY (`updated_by`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `payments_ibfk_3` FOREIGN KEY (`sales_id`) REFERENCES `sales` (`sales_id`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`updated_by`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `products_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`);

--
-- Constraints for table `purchased_items`
--
ALTER TABLE `purchased_items`
  ADD CONSTRAINT `purchased_items_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`),
  ADD CONSTRAINT `purchased_items_ibfk_2` FOREIGN KEY (`purchase_id`) REFERENCES `purchases` (`purchase_id`);

--
-- Constraints for table `purchases`
--
ALTER TABLE `purchases`
  ADD CONSTRAINT `purchases_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`supplier_id`),
  ADD CONSTRAINT `purchases_ibfk_2` FOREIGN KEY (`updated_by`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `sales`
--
ALTER TABLE `sales`
  ADD CONSTRAINT `sales_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
  ADD CONSTRAINT `sales_ibfk_2` FOREIGN KEY (`updated_by`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `sales_items`
--
ALTER TABLE `sales_items`
  ADD CONSTRAINT `sales_items_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`),
  ADD CONSTRAINT `sales_items_ibfk_2` FOREIGN KEY (`sales_id`) REFERENCES `sales` (`sales_id`),
  ADD CONSTRAINT `sales_items_ibfk_3` FOREIGN KEY (`stock_id`) REFERENCES `stocks` (`stock_id`);

--
-- Constraints for table `stocks`
--
ALTER TABLE `stocks`
  ADD CONSTRAINT `stocks_ibfk_1` FOREIGN KEY (`purchased_item_id`) REFERENCES `purchased_items` (`purchased_item_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
