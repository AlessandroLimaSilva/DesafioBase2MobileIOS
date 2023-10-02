Feature: Login

  @automatizado @001
  Scenario: Não realizar compra sem um usuario cadastrado
    Given que um usuario tenha colocado um item no carrinho
    And que tenha acessado o checkout
    When quando ele informa nome ImYourFather e senha Luke não cadastrado
    Then ele é informado que o usuario não esta cadastrado

  @automatizado @002
  Scenario: Não realizar login sem informar um nome de usuario
    Given que um usuario tenha colocado um item no carrinho
    And que tenha acessado o checkout
    When quando ele informa a senha 123456 esquecendo de informar o nome de usuario
    Then ele é informado que o nome de usuario não foi preenchido

  @automatizado @003
  Scenario: Não realizar login sem informar a senha de usuario
    Given que um usuario tenha colocado um item no carrinho
    And que tenha acessado o checkout
    When quando ele informa nome de usuario ImmigrantSong esquecendo de informar a senha
    Then ele é informado que a senha não foi preenchida

  @automatizado @004
  Scenario: Não realizar login com usuario bloqueado
    Given que um usuario tenha colocado um item no carrinho
    And que tenha acessado o checkout
    When ele informa um usuario bloqueado
    Then ele é informado que o usuario esta bloqueado

  @automatizado @005
  Scenario: Realizar logout com sucesso
    Given que o usuario realizou o login
    When quando o usuario seleciona logout
    Then o logout é realizado com sucesso