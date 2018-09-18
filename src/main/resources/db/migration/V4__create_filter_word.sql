
CREATE TABLE `filterword` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `article_id` bigint unsigned NOT NULL,
  `word` varchar(255) NOT NULL DEFAULT '',
   foreign key (`article_id`) references article(`id`) on delete cascade,
  PRIMARY KEY (`id`)
);

CREATE TABLE `article_filterwords` (
  `article_id` bigint unsigned NOT NULL,
  `filterwords_id` bigint unsigned NOT NULL,
   foreign key (`article_id`) references article(`id`) on delete cascade,
   foreign key (`filterwords_id`) references filterword(`id`) on delete cascade,
   CONSTRAINT PK_article_filterwords PRIMARY KEY (`article_id`,`filterwords_id`)
);
commit;
