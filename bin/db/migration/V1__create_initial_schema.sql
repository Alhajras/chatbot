CREATE TABLE `article` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL DEFAULT '',
  `priority` int NOT NULL DEFAULT 0,
  `link` varchar(255) NOT NULL DEFAULT '',
 
  PRIMARY KEY (`id`)
);

CREATE TABLE `keyword` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `article_id` bigint unsigned NOT NULL,
  `keyword` varchar(255) NOT NULL DEFAULT '',
   foreign key (`article_id`) references article(`id`) on delete cascade,
  PRIMARY KEY (`id`)
);

CREATE TABLE `article_keywords` (
  `article_id` bigint unsigned NOT NULL,
  `keywords_id` bigint unsigned NOT NULL,
   foreign key (`article_id`) references article(`id`) on delete cascade,
   foreign key (`keywords_id`) references keyword(`id`) on delete cascade,
   CONSTRAINT PK_article_keywords PRIMARY KEY (`article_id`,`keywords_id`)
);
commit;
