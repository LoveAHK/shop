-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Дек 07 2022 г., 11:40
-- Версия сервера: 5.6.51
-- Версия PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `Shop`
--

-- --------------------------------------------------------

--
-- Структура таблицы `arenda`
--

CREATE TABLE `arenda` (
  `id` bigint(20) NOT NULL,
  `datenachala` varchar(255) DEFAULT NULL,
  `nomerdogovora` varchar(10) DEFAULT NULL,
  `street` varchar(30) DEFAULT NULL,
  `mesto_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `arenda`
--

INSERT INTO `arenda` (`id`, `datenachala`, `nomerdogovora`, `street`, `mesto_id`) VALUES
(10, '2022-12-01', '465', 'пролд', NULL),
(33, '2022-12-08', '123', 'пролд', 2);

-- --------------------------------------------------------

--
-- Структура таблицы `checks`
--

CREATE TABLE `checks` (
  `id` bigint(20) NOT NULL,
  `inn` varchar(12) DEFAULT NULL,
  `kolvotovar` int(11) NOT NULL,
  `summi` int(11) NOT NULL,
  `oplatasposob_id` bigint(20) DEFAULT NULL,
  `personal_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `checks`
--

INSERT INTO `checks` (`id`, `inn`, `kolvotovar`, `summi`, `oplatasposob_id`, `personal_id`) VALUES
(8, '7689087656', 1, 4000, 2, 6);

-- --------------------------------------------------------

--
-- Структура таблицы `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(34);

-- --------------------------------------------------------

--
-- Структура таблицы `laborbook`
--

CREATE TABLE `laborbook` (
  `id` bigint(20) NOT NULL,
  `datenach` varchar(255) DEFAULT NULL,
  `nomer` varchar(30) DEFAULT NULL,
  `post_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `laborbook`
--

INSERT INTO `laborbook` (`id`, `datenach`, `nomer`, `post_id`) VALUES
(5, '2022-12-01', '789009', NULL),
(32, '2022-12-05', '123456', 2);

-- --------------------------------------------------------

--
-- Структура таблицы `mesto`
--

CREATE TABLE `mesto` (
  `id` bigint(20) NOT NULL,
  `city` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `mesto`
--

INSERT INTO `mesto` (`id`, `city`) VALUES
(1, 'Москва'),
(2, 'Санкт-Петербург');

-- --------------------------------------------------------

--
-- Структура таблицы `oplatasposob`
--

CREATE TABLE `oplatasposob` (
  `id` bigint(20) NOT NULL,
  `sposobsale` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `oplatasposob`
--

INSERT INTO `oplatasposob` (`id`, `sposobsale`) VALUES
(1, 'Наличные'),
(2, 'Карта');

-- --------------------------------------------------------

--
-- Структура таблицы `personal`
--

CREATE TABLE `personal` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) NOT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `flat` varchar(255) DEFAULT NULL,
  `home` varchar(255) DEFAULT NULL,
  `middlename` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `nomerpasporta` varchar(255) DEFAULT NULL,
  `salary` varchar(255) DEFAULT NULL,
  `seriapasporta` varchar(255) DEFAULT NULL,
  `snils` varchar(255) DEFAULT NULL,
  `street` varchar(30) DEFAULT NULL,
  `surname` varchar(30) DEFAULT NULL,
  `thebuildingofthehouse` varchar(255) DEFAULT NULL,
  `laborbook_id` bigint(20) DEFAULT NULL,
  `mesto_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `personal`
--

INSERT INTO `personal` (`id`, `active`, `birthday`, `flat`, `home`, `middlename`, `name`, `nomerpasporta`, `salary`, `seriapasporta`, `snils`, `street`, `surname`, `thebuildingofthehouse`, `laborbook_id`, `mesto_id`, `user_id`) VALUES
(6, b'0', '2022-12-01', '34', '3', 'ваолдл', 'вщал', '345345', '234234', '7654', '34534534534', 'ваол', 'лаводл', '2', NULL, 1, NULL),
(7, b'0', '2022-12-01', '34', '3', 'апрорп', 'еанпгрш', '345345', '234234', '5678', '34534534534', 'ророл', 'кенг', '2', NULL, 1, NULL),
(11, b'1', '2022-12-22', '34', '3', 'Александрович', 'йцуке', '123412', '234234', '1234', '34534534534', 'ывапро', 'йцукенг', '2', NULL, 1, 12),
(13, b'1', '2022-12-08', '34', '3', 'ролррл', 'одлолдолд', '123123', '234234', '1234', '34534534534', 'рполд', 'оллролро', '2', NULL, 1, 14),
(15, b'1', '2022-11-29', '234', '3', 'Александрович', 'рывлораолвыр', '123123', '234234', '4342', '34534534534', 'пролд', 'лоывалыва', '2', NULL, 1, 16),
(17, b'1', '2022-11-09', '3', '3', 'роалывад', 'рыовлад', '748938', '232323', '7548', '78493098493', 'ровал', 'ывпоарло', '3', NULL, 1, 18),
(19, b'1', '2022-12-15', '34', '3', 'йцукенгш', 'йцукенг', '123456', '234234', '1234', '34534534534', 'пролд', 'йцукенгш', '3', NULL, 1, 20),
(21, b'1', '2022-12-15', '34', '3', 'йцукенгш', 'йцукенг', '123456', '234234', '1234', '34534534534', 'пролд', 'йцукенгш', '3', NULL, 1, 22),
(23, b'1', '2022-12-15', '34', '3', 'йцукенгш', 'йцукенг', '123456', '234234', '1234', '34534534534', 'пролд', 'йцукенгш', '3', NULL, 1, 24),
(25, b'1', '2022-12-15', '34', '3', 'йцукенгш', 'йцукенг', '123456', '234234', '1234', '34534534534', 'пролд', 'йцукенгш', '3', NULL, 1, 26),
(27, b'1', '2022-12-15', '34', '3', 'йцукенгш', 'йцукенг', '123456', '234234', '1234', '34534534534', 'пролд', 'йцукенгш', '3', NULL, 1, 28),
(29, b'1', '2022-12-15', '34', '3', 'йцукенгш', 'йцукенг', '123456', '234234', '1234', '34534534534', 'пролд', 'йцукенгш', '3', 5, 1, 30);

-- --------------------------------------------------------

--
-- Структура таблицы `post`
--

CREATE TABLE `post` (
  `id` bigint(20) NOT NULL,
  `postname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `post`
--

INSERT INTO `post` (`id`, `postname`) VALUES
(1, 'Администратор'),
(2, 'Кассир'),
(3, 'Кладовщик'),
(4, 'Уборщик');

-- --------------------------------------------------------

--
-- Структура таблицы `producttype`
--

CREATE TABLE `producttype` (
  `id` bigint(20) NOT NULL,
  `tiptovara` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `producttype`
--

INSERT INTO `producttype` (`id`, `tiptovara`) VALUES
(1, 'Самокат'),
(2, 'Велосипед'),
(3, 'Гири'),
(4, 'Турник'),
(5, 'Моно-колесо');

-- --------------------------------------------------------

--
-- Структура таблицы `proizvod`
--

CREATE TABLE `proizvod` (
  `id` bigint(20) NOT NULL,
  `country` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `proizvod`
--

INSERT INTO `proizvod` (`id`, `country`) VALUES
(1, 'Россия'),
(2, 'Германия'),
(3, 'США'),
(4, 'Китай');

-- --------------------------------------------------------

--
-- Структура таблицы `tovar`
--

CREATE TABLE `tovar` (
  `id` bigint(20) NOT NULL,
  `nametovar` varchar(50) DEFAULT NULL,
  `producttype_id` bigint(20) DEFAULT NULL,
  `proizvod_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `tovar`
--

INSERT INTO `tovar` (`id`, `nametovar`, `producttype_id`, `proizvod_id`) VALUES
(9, 'СамокатЯндекс', 1, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `tovarcheck`
--

CREATE TABLE `tovarcheck` (
  `id` bigint(20) NOT NULL,
  `checks_id` bigint(20) DEFAULT NULL,
  `tovar_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`id`, `active`, `password`, `username`) VALUES
(1, b'1', 'admin', 'admin'),
(2, b'1', 'user', 'user'),
(3, b'1', 'kasir', 'kasir'),
(4, b'1', 'arenda', 'arenda'),
(5, b'1', 'klad', 'klad'),
(12, b'1', '123', 'dana'),
(14, b'0', '$2a$08$D5EV61m3hhlDwLe3HX9uC.DxR7d8Cgsk8OY5WZUUBWVBjRpc1h7uW', 'DANA'),
(16, b'1', '$2a$08$CUHEigAxTGqi7GTu.FmsEecblK8dwHa9YGIC.q4Tm9DQMPidBTFs2', 'user1'),
(18, b'1', '$2a$08$KO1KXiGVyeXTVeJB/blhU.Dc6DAlhl91YPBZ0uoLNXq9RjxdyUU16', 'admins'),
(20, b'0', '$2a$08$M7JmrrDfIczhOzvae6gqSO31gskd6sDaV8RZrjuG6g6/FN4m9pmjC', 'qwerty'),
(22, b'0', '$2a$08$Mlw6.Yj57I9rL5TbIK74aOtC1Qv7wZ5KWhqViqnLQ84jujn8d7fEi', 'qwerty2'),
(24, b'0', '$2a$08$QxqX0KUEBGFd6pjrlPWWUeDGPeKZ.k5lmq/Ny8z2VYoh0YAtmncRi', 'qwerty3'),
(26, b'0', '$2a$08$x6NG/1EIMa9zPHnprNu84.kS/554qaSsfDrGBnlkws.0moEz9.FYq', 'qwerty4'),
(28, b'0', '$2a$08$ffjG5J4ZLnqZsmPsoHPsjuEGHk3Ic6b10cYEjnVWuiv5npHDvftFS', 'qwerty4'),
(30, b'0', '$2a$08$7aE1sqjaIOa0kvouLlvQ/ujfN1z21.d1O761UIK/2hwO/aljDg0gG', 'qwerty5');

-- --------------------------------------------------------

--
-- Структура таблицы `user_role`
--

CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `roles` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `user_role`
--

INSERT INTO `user_role` (`user_id`, `roles`) VALUES
(1, 'ADMIN'),
(2, 'USER'),
(3, 'KASSIR'),
(4, 'ARENDODATEL'),
(5, 'KKADOVSHIK'),
(12, 'USER'),
(14, 'USER'),
(16, 'USER'),
(18, 'ADMIN'),
(20, 'USER'),
(22, 'USER'),
(24, 'USER'),
(26, 'USER'),
(28, 'USER'),
(30, 'USER');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `arenda`
--
ALTER TABLE `arenda`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5v50t2q6ctgwk9qic4nnyegkr` (`mesto_id`);

--
-- Индексы таблицы `checks`
--
ALTER TABLE `checks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK63qnwhya8bgs55u5sw8vawfyq` (`oplatasposob_id`),
  ADD KEY `FKj1l5axljpu50cp1gxs4slhpf2` (`personal_id`);

--
-- Индексы таблицы `laborbook`
--
ALTER TABLE `laborbook`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8dd7cegdka852kfavxq42kbb1` (`post_id`);

--
-- Индексы таблицы `mesto`
--
ALTER TABLE `mesto`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `oplatasposob`
--
ALTER TABLE `oplatasposob`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `personal`
--
ALTER TABLE `personal`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdp7sdjsdxgl403yhn2v9n6in9` (`laborbook_id`),
  ADD KEY `FKd6yktu1fh3ymrthj9v2xv43mi` (`mesto_id`),
  ADD KEY `FKfymkmbeagv4fyvm7769lowtk0` (`user_id`);

--
-- Индексы таблицы `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `producttype`
--
ALTER TABLE `producttype`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `proizvod`
--
ALTER TABLE `proizvod`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `tovar`
--
ALTER TABLE `tovar`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkh7yvscpyagf0lqjk1x3euu9f` (`producttype_id`),
  ADD KEY `FKmannsnpkap7sh096tbjo15ci4` (`proizvod_id`);

--
-- Индексы таблицы `tovarcheck`
--
ALTER TABLE `tovarcheck`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjkp8tslqg3scb9puvwbi104rn` (`checks_id`),
  ADD KEY `FKjxqic4hcdpfrwjbwuijh318i0` (`tovar_id`);

--
-- Индексы таблицы `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `user_role`
--
ALTER TABLE `user_role`
  ADD KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `mesto`
--
ALTER TABLE `mesto`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `arenda`
--
ALTER TABLE `arenda`
  ADD CONSTRAINT `FK5v50t2q6ctgwk9qic4nnyegkr` FOREIGN KEY (`mesto_id`) REFERENCES `mesto` (`id`);

--
-- Ограничения внешнего ключа таблицы `checks`
--
ALTER TABLE `checks`
  ADD CONSTRAINT `FK63qnwhya8bgs55u5sw8vawfyq` FOREIGN KEY (`oplatasposob_id`) REFERENCES `oplatasposob` (`id`),
  ADD CONSTRAINT `FKj1l5axljpu50cp1gxs4slhpf2` FOREIGN KEY (`personal_id`) REFERENCES `personal` (`id`);

--
-- Ограничения внешнего ключа таблицы `laborbook`
--
ALTER TABLE `laborbook`
  ADD CONSTRAINT `FK8dd7cegdka852kfavxq42kbb1` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`);

--
-- Ограничения внешнего ключа таблицы `personal`
--
ALTER TABLE `personal`
  ADD CONSTRAINT `FKd6yktu1fh3ymrthj9v2xv43mi` FOREIGN KEY (`mesto_id`) REFERENCES `mesto` (`id`),
  ADD CONSTRAINT `FKdp7sdjsdxgl403yhn2v9n6in9` FOREIGN KEY (`laborbook_id`) REFERENCES `laborbook` (`id`),
  ADD CONSTRAINT `FKfymkmbeagv4fyvm7769lowtk0` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Ограничения внешнего ключа таблицы `tovar`
--
ALTER TABLE `tovar`
  ADD CONSTRAINT `FKkh7yvscpyagf0lqjk1x3euu9f` FOREIGN KEY (`producttype_id`) REFERENCES `producttype` (`id`),
  ADD CONSTRAINT `FKmannsnpkap7sh096tbjo15ci4` FOREIGN KEY (`proizvod_id`) REFERENCES `proizvod` (`id`);

--
-- Ограничения внешнего ключа таблицы `tovarcheck`
--
ALTER TABLE `tovarcheck`
  ADD CONSTRAINT `FKjkp8tslqg3scb9puvwbi104rn` FOREIGN KEY (`checks_id`) REFERENCES `checks` (`id`),
  ADD CONSTRAINT `FKjxqic4hcdpfrwjbwuijh318i0` FOREIGN KEY (`tovar_id`) REFERENCES `tovar` (`id`);

--
-- Ограничения внешнего ключа таблицы `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
