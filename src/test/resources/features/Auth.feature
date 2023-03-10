#language:ru

Функциональность: Авторизация

  Сценарий: Авторизация в кабинете (позитивный)
    Пусть открыта страница с формой авторизации "http://localhost:9999/"
    Когда пользователь пытается авторизоваться с именем "vasya" и паролем "qwerty123"
    И пользователь вводит проверочный код из смс "12345"
    Тогда происходит успешная авторизация и пользователь попадает на страницу 'Личный кабинет'

  Сценарий: Перевод 5000 рублей
    Пусть открыта страница с формой авторизации "http://localhost:9999/"
    Когда пользователь пытается авторизоваться с именем "vasya" и паролем "qwerty123"
    И пользователь вводит проверочный код из смс "12345"
    Тогда происходит успешная авторизация и пользователь попадает на страницу 'Личный кабинет'
    Когда пользователь переводит "5000" рублей с карты с номером "5559 0000 0000 0002" на свою 1 карту с главной страницы,
    Тогда баланс его карты "5559 0000 0000 0001" из списка на главной странице должен стать 15000 рублей

  Сценарий: Перевод 5000 рублей на 2 карту
    Пусть открыта страница с формой авторизации "http://localhost:9999/"
    Когда пользователь пытается авторизоваться с именем "vasya" и паролем "qwerty123"
    И пользователь вводит проверочный код из смс "12345"
    Тогда происходит успешная авторизация и пользователь попадает на страницу 'Личный кабинет'
    Когда пользователь переводит "5000" рублей с карты с номером "5559 0000 0000 0001" на свою 2 карту с главной страницы,
    Тогда баланс его карты "5559 0000 0000 0002" из списка на главной странице должен стать 10000 рублей