Feature: Classificar item

  @automatizado @001
  Scenario Outline: Classificar produto de um usuario logado com sucesso
    Given que o usuario realizou o login
    When o usuario seleciona uma <nota>
    Then o produto é classificado com sucesso
    Examples:
      | nota |
      | 1    |
      | 2    |
      | 3    |
      | 4    |
      | 5    |

  @automatizado @002
  Scenario Outline: Classificar produto de um usuario logado em checkout com sucesso
    Given que o usuario realizou o login
    And que ele tenha adicionado um item ao carrinho
    When o usuario seleciona uma <nota>
    Then o produto é classificado com sucesso
    Examples:
      | nota |
      | 1    |
      | 2    |
      | 3    |
      | 4    |
      | 5    |

  @automatizado @003
  Scenario Outline: Classificar produto de um usuario não logado com sucesso
    When o usuario seleciona uma <nota>
    Then o produto é classificado com sucesso
    Examples:
      | nota |
      | 1    |
      | 2    |
      | 3    |
      | 4    |
      | 5    |

  @automatizado @004
  Scenario Outline: Classificar produto de um usuario não logado em checkout com sucesso
    Given que ele tenha adicionado um item ao carrinho
    When o usuario seleciona uma <nota>
    Then o produto é classificado com sucesso
    Examples:
      | nota |
      | 1    |
      | 2    |
      | 3    |
      | 4    |
      | 5    |
