#Base line file is need to establish baseline for existing databases;
CREATE TABLE `product` (
       `id` bigint NOT NULL AUTO_INCREMENT,
       `created_at` datetime(6) DEFAULT NULL,
       `created_by` varchar(255) DEFAULT NULL,
       `is_deleted` bit(1) NOT NULL,
       `description` varchar(255) DEFAULT NULL,
       `imageurl` varchar(255) DEFAULT NULL,
       `price` double DEFAULT NULL,
       `product_name` varchar(255) DEFAULT NULL,
       `title` varchar(255) DEFAULT NULL,
       `category_id` bigint DEFAULT NULL,
       `updated_at` datetime(6) DEFAULT NULL,
       PRIMARY KEY (`id`),
       FOREIGN KEY (category_id) REFERENCES category(id)
);
CREATE TABLE `category` (
       `id` bigint NOT NULL AUTO_INCREMENT,
       `created_at` datetime(6) DEFAULT NULL,
       `created_by` varchar(255) DEFAULT NULL,
       `is_deleted` bit(1) NOT NULL,
       `name` varchar(255) DEFAULT NULL,
       `description` varchar(255) DEFAULT NULL,
       `updated_at` datetime(6) DEFAULT NULL,
       PRIMARY KEY (`id`)
);
ALTER TABLE product ADD specifications varchar(255) DEFAULT NULL;