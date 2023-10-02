@compra
Feature: Compra


  @automatizado @001
  Scenario: Remover um item do carrinho com sucesso
    Given que um usuario tenha colocado um item no carrinho
    But quando ele acessou o carrinho
    When ele selecionou remover o item do carrinho
    Then o item foi removido com sucesso

  @automatizado @002
  Scenario: Remover varios itens do carrinho com sucesso
    Given que um usuario tenha colocado diversos itens no carrinho
    But quando ele acessou o carrinho
    When ele selecionou excluir todos os itens no carrinho
    Then os itens foram excluidos com sucesso

  @automatizado @003 @teste
  Scenario: Realizar compra com sucesso
    Given que o usuario realizou o login
    And que ele tenha adicionado um item ao carrinho
    And em entrega tenha informado o nome completo Rebecca Winter, rua Mandorley 112, cidade Truro, cep 89750 e pais United Kingdom
    And em pagamento tenha informado nome titular do cartão Rebecca Winter, numero do cartão 325812657568789, data de validade 0325 e codigo de segurança 123
    When o usuario confirmar a compra
    Then a compra é realizada com sucesso
