package com.SerenityBDDAppiumTemplate.stepdefinitions;

import com.SerenityBDDAppiumTemplate.steps.*;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class CompraStepDefinition {

    @Steps
    PaginaInicialStep paginaInicialStep;

    @Steps
    MyCartStep myCartStep;

    @Steps
    ItemStep itemStep;

    @Steps
    CheckoutStep checkoutStep;

    @Given("que o usuario acessou o menu")
    public void queOUsuarioAcessouOMenu(){
        paginaInicialStep.clicarEmMenuButton();
    }

    @Given("que um usuario tenha colocado um item no carrinho")
    public void queUmTenhaColocadoUmItemNoCarrinho(){
        paginaInicialStep.clicarSauceLabsBackPackCard();
        itemStep.clicarAdicionarItemAoCarrinhoButton();
        paginaInicialStep.clicarCatalogButton();
    }

    @But("quando ele acessou o carrinho")
    public void quandoEleAcessouOCarrinho(){
        paginaInicialStep.clicarCartButton();
    }

    @When("ele selecionou remover o item do carrinho")
    public void eleSelecionouRemoverOItemDoCarrinho(){
        myCartStep.clicarExcluirItem();
    }

    @Then("o item foi removido com sucesso")
    public void oItemFoiRemovidoComSucesso(){
        Assert.assertTrue(myCartStep.retornaSeCarrinhoVazioEVisivel());
    }

    @Given("que um usuario tenha colocado diversos itens no carrinho")
    public void queUmUsuarioTenhaColocadoDiversosItensNoCarrinho(){

        paginaInicialStep.clicarSauceLabsBackPackCard();
        itemStep.clicarAdicionarItemAoCarrinhoButton();
        paginaInicialStep.clicarCatalogButton();

        paginaInicialStep.clicarSauceLabsBikeLightCard();
        itemStep.clicarAdicionarItemAoCarrinhoButton();
        paginaInicialStep.clicarCatalogButton();

        paginaInicialStep.clicarSauceLabsBoltTShirtCard();
        itemStep.clicarAdicionarItemAoCarrinhoButton();
        paginaInicialStep.clicarCatalogButton();

        paginaInicialStep.clicarSauceLabsFleeceJacketCard();
        itemStep.clicarAdicionarItemAoCarrinhoButton();
        paginaInicialStep.clicarCatalogButton();

        paginaInicialStep.clicarSauceLabsOnesieCard();
        itemStep.clicarAdicionarItemAoCarrinhoButton();
        paginaInicialStep.clicarCatalogButton();

        paginaInicialStep.clicarTestAllTheThingsTShirtCard();
        itemStep.clicarAdicionarItemAoCarrinhoButton();
        paginaInicialStep.clicarCatalogButton();

    }

    @Given("ele selecionou excluir todos os itens no carrinho")
    public void eleSelecionouExcluirTodosOsItensNoCarrinho(){
        myCartStep.excluirTodosOsItensDoCarrinho();
    }

    @Then("os itens foram excluidos com sucesso")
    public void osItensForamExcluidosComSucesso(){
        Assert.assertTrue(myCartStep.retornaSeCarrinhoVazioEVisivel());
    }

    @And("que ele tenha adicionado um item ao carrinho")
    public void queEleTenhaAdicionadoUmItemAoCarrinho(){
        paginaInicialStep.clicarTestAllTheThingsTShirtCard();
        itemStep.clicarAdicionarItemAoCarrinhoButton();
    }

    @And("^em entrega tenha informado o nome completo (.*), rua (.*), cidade (.*), cep (.*) e pais (.*)$")
    public void emEntregaTenhaInformadoONomeCompletoRuaCidadeCepEPais(String nomeCompleto,String rua,String cidade,String cep,String pais){
        paginaInicialStep.clicarCartButton();
        myCartStep.clicarProceedToCheckoutButton();
        checkoutStep.preencherFullNameInputField(nomeCompleto);
        checkoutStep.preencherAddressLineOneInputField(rua);
        checkoutStep.preencherCityInputField(cidade);
        checkoutStep.preencherZipCodeInputField(cep);
        checkoutStep.preencherCountryInputField(pais);
        checkoutStep.clicarToPaymentButton();
    }

    @And("^em pagamento tenha informado nome titular do cartão (.*), numero do cartão (.*), data de validade (.*) e codigo de segurança (.*)$")
    public void emPagamentoTenhaInformadoNomeDoTitularDoCartaoNumeroDoCartaoDataDeValidadeECodigoDeSeguranca(String nomeCompletoCard,String numeroDoCartao,String dataDeValidade,String codigoDeSeguranca) throws InterruptedException {
        checkoutStep.preencherCardFullNameInputField(nomeCompletoCard);
        checkoutStep.preencherCardNumberInputField(numeroDoCartao);
        checkoutStep.preencherExpirationDateInputField(dataDeValidade);
        checkoutStep.preencherSecurityCodeInputField(codigoDeSeguranca);
        //checkoutStep.clicarCardLabelWorkAround();
    }

    @When("o usuario confirmar a compra")
    public void oUsuarioConfirmarACompra(){
        checkoutStep.clicarReviewOrderButton();
    }

    @Then("a compra é realizada com sucesso")
    public void aCompraERealizadaComSucesso(){
        Assert.assertTrue(checkoutStep.
                retornaTextoCheckoutCompleteLabel().
                equalsIgnoreCase("Checkout Complete"));
    }

    @And("em checkout informou a rua (.*), cidade (.*), cep (.*) e pais (.*) e não informou nome completo$")
    public void emCheckoutInformouARuaCidadeCepEPaisENaoInformouNomeCompleto(String rua,String cidade,String cep,String pais){
        paginaInicialStep.clicarCartButton();
        myCartStep.clicarProceedToCheckoutButton();
        checkoutStep.preencherAddressLineOneInputField(rua);
        checkoutStep.preencherCityInputField(cidade);
        checkoutStep.preencherZipCodeInputField(cep);
        checkoutStep.preencherCountryInputField(pais);
    }

    @When("o usuario confirmar para ir ao pagamento")
    public void oUsuarioConfirmarParaIrAoPagamento(){
        checkoutStep.clicarToPaymentButton();
    }

    @Then("é informado que o nome completo não foi informado")
    public void eInformadoQueONomeCompletoNaoFoiInformado(){
        Assert.assertTrue(checkoutStep.retornaTextoPleaseProvideYourFullnameLabel().equalsIgnoreCase("Please provide your full name."));
    }

    @And("^em checkout informou o nome completo (.*), cidade (.*), cep (.*) e pais (.*) e não informa a rua$")
    public void emCheckoutInformouONomeCompletoCidadeCEPEPaisENaoInformaARua(String nomeCompleto,String cidade,String cep,String pais){
        paginaInicialStep.clicarCartButton();
        myCartStep.clicarProceedToCheckoutButton();
        checkoutStep.preencherFullNameInputField(nomeCompleto);
        checkoutStep.preencherCityInputField(cidade);
        checkoutStep.preencherZipCodeInputField(cep);
        checkoutStep.preencherCountryInputField(pais);
    }

    @Then("é informado que a rua não foi informada")
    public void eInformadoQueARuaNaofoiInformada(){
        Assert.assertTrue(checkoutStep.retornaTextoPleaseProvideYourAddressLabel().equalsIgnoreCase("Please provide your address."));
    }

    @And("^em checkout informou o nome completo (.*), rua (.*), cep (.*), pais (.*) e não informou a cidade$")
    public void emCheckoutInformouONomeCompletoCEPPaisENaoInformouACidade(String nomeCompleto,String rua,String cep,String pais){
        paginaInicialStep.clicarCartButton();
        myCartStep.clicarProceedToCheckoutButton();
        checkoutStep.preencherFullNameInputField(nomeCompleto);
        checkoutStep.preencherAddressLineOneInputField(rua);
        checkoutStep.preencherZipCodeInputField(cep);
        checkoutStep.preencherCountryInputField(pais);
    }

    @Then("é informado que a cidade não foi informada")
    public void eInformadoQueACidadeNaoFoiInformada(){
        Assert.assertTrue(checkoutStep.retornaTextoPleaseProvideYourCityLabel().equalsIgnoreCase("Please provide your city."));
    }

    @And("^em check out informou o nome completo (.*), rua (.*), cidade (.*), pais (.*) e não informou o codigo postal$")
    public void emCheckoutInformouONomeCompletoRuaCidadePaisENaoInformouOCodigoPostal(String nomeCompleto,String rua,String cidade,String pais){
        paginaInicialStep.clicarCartButton();
        myCartStep.clicarProceedToCheckoutButton();
        checkoutStep.preencherFullNameInputField(nomeCompleto);
        checkoutStep.preencherAddressLineOneInputField(rua);
        checkoutStep.preencherCityInputField(cidade);
        checkoutStep.preencherCountryInputField(pais);
    }

    @Then("é informado que o codigo postal não foi informado")
    public void eInformadoQueOCodigoPostalNaoFoiInformado(){
        Assert.assertTrue(checkoutStep.retornaTextoPleaseProvideYourZipCodeLabel().equalsIgnoreCase("Please provide your zip code."));
    }

    @And("^em checkout informou o nome completo (.*), rua (.*), cidade (.*), zip code (.*) e não informou o pais$")
    public void emCheckoutInformouONomeCompletoRuaCidadeZipCodeENaoInformouOPais(String nomeCompleto,String rua,String cidade,String cep){
        paginaInicialStep.clicarCartButton();
        myCartStep.clicarProceedToCheckoutButton();
        checkoutStep.preencherFullNameInputField(nomeCompleto);
        checkoutStep.preencherAddressLineOneInputField(rua);
        checkoutStep.preencherCityInputField(cidade);
        checkoutStep.preencherZipCodeInputField(cep);
    }

    @Then("é informado que o pais não foi informado")
    public void eInformadoQueOPaisNaoFoiInformado(){
        Assert.assertTrue(checkoutStep.retornaTextoPleaseProvideYourCountryLabel().equalsIgnoreCase("Please provide your country."));
    }

    @And("^em revisar pedido tenha informado o numero do cartão (.*), data de validade (.*) e codigo de segurança (.*) e não informou o nome completo$")
    public void emRevisarPedidoTenhaInformadoONumeroDoCartaoDataDeValidadeECodigoDeSegurancaENaoInformouONomeCompleto(String numeroDoCartao,String dataDeValidade,String codigoDeSeguranca){
        checkoutStep.preencherCardNumberInputField(numeroDoCartao);
        checkoutStep.preencherExpirationDateInputField(dataDeValidade);
        checkoutStep.preencherSecurityCodeInputField(codigoDeSeguranca);
        checkoutStep.clicarCardLabelWorkAround();
    }

    @When("o usuario confirmar revisar o pedido")
    public void oUsuarioConfirmarRevisarOPedido(){
        checkoutStep.clicarReviewOrderButton();
    }

    @Then("é informado que o nome completo do cartao não foi informado")
    public void eInformadoQueONomeCompletoDoCartaoNaoFoiInformado(){
        Assert.assertTrue(checkoutStep.retornaTextoValueLooksInvalidLabel().equalsIgnoreCase("Value looks invalid."));
    }

    @Then("é informado que o numero do cartão não foi informado")
    public void eInformadoQueONumeroDoCartaoNaoFoiInformado(){
        Assert.assertTrue(checkoutStep.retornaTextoValueLooksInvalidLabel().equalsIgnoreCase("Value looks invalid."));
    }

    @Then("é informado que a data de validade do cartão não foi informado")
    public void eInformadoQueADataDeValidadeDoCartaoNaoFoiInformado(){
        Assert.assertTrue(checkoutStep.retornaTextoValueLooksInvalidLabel().equalsIgnoreCase("Value looks invalid."));
    }

    @Then("é informado que o codigo de segurança do cartão não foi informado")
    public void eInformadoQueOCodigoDeSegurancaDoCartaoNaoFoiInformado(){
        Assert.assertTrue(checkoutStep.retornaTextoValueLooksInvalidLabel().equalsIgnoreCase("Value looks invalid."));
    }

    @And("^em revisar pedido tenha informado o nome completo (.*), data de validade (.*), codigo de segurança (.*) e não informou o numero do cartão$")
    public void emRevisarPedidoTenhaInformadoONomeCompletoDataDeValidadeCodigoDeSegurancaENaoInformouONumeroDoCartao(String nomeCompletoCartao,String dataDeValidade,String codigoDeSeguranca){
        checkoutStep.preencherCardFullNameInputField(nomeCompletoCartao);
        checkoutStep.preencherExpirationDateInputField(dataDeValidade);
        checkoutStep.preencherSecurityCodeInputField(codigoDeSeguranca);
        checkoutStep.clicarCardLabelWorkAround();
    }

    @And("^em revisar pedido tenha informado o nome completo (.*), numero do cartão (.*), codigo de segurança (.*) e não informou a data de validade$")
    public void emRevisarPedidoTenhaInformadoONomeCompletoNumeroDoCartaoCodigoDeSegurancaENaoInformouADataDeValidade(String nomeCompletoCartao,String numeroDoCartao,String codigoDeSeguranca){
        checkoutStep.preencherCardFullNameInputField(nomeCompletoCartao);
        checkoutStep.preencherCardNumberInputField(numeroDoCartao);
        checkoutStep.preencherSecurityCodeInputField(codigoDeSeguranca);
        checkoutStep.clicarCardLabelWorkAround();
    }

    @And("^em revisar pedido tenha informado o nome completo (.*), numero do cartão (.*), data de validade (.*) e não informou o codigo de seguranca$")
    public void emRevisarPedidotenhaInformadoONomeCompletoNumeroDoCartaoDataDeValidadeENaoInformouOCodigoDeSeguranca(String nomeCompletoCartao,String numeroDoCartao,String dataDeValidade){
        checkoutStep.preencherCardFullNameInputField(nomeCompletoCartao);
        checkoutStep.preencherCardNumberInputField(numeroDoCartao);
        checkoutStep.preencherExpirationDateInputField(dataDeValidade);
        checkoutStep.clicarCardLabelWorkAround();
    }

    @And("ele não tenha selecionado meu endereço de cobrança é igual ao meu endereço de entrega")
    public void eleNaoTenhaSelecionadoMeuEnderecoDeCobrancaEIgualAOMeuEnderecoDeEntrega(){
        checkoutStep.clicarMyBillingAddressIsTheSameAsMyShippingAddressCheck();
    }

    @And("^o usuario informou a rua (.*), cidade (.*), cep (.*), pais (.*) e não informou nome completo$")
    public void oUsuarioInformouARuaCidadeCEPEPaisENaoInformouNomeCompleto(String rua, String cidade, String cep, String pais){
        checkoutStep.preencherAddressLineOneInputField(rua);
        checkoutStep.preencherCityInputField(cidade);
        checkoutStep.preencherZipCodeInputField(cep);
        checkoutStep.preencherCountryInputField(pais);
    }

    @Then("é informado que o nome não foi informado")
    public void eInformadoQueONomeNaoFoiInformado(){
        Assert.assertTrue(checkoutStep.retornaTextoPleaseProvideYourFullnameLabel().equalsIgnoreCase("Please provide your full name."));
    }

    @And("^o usuario informou o nome completo (.*), cidade (.*), cep (.*) e pais (.*) e não informa a rua$")
    public void oUsuarioInformaouONomeCompletoCidadeCEPEPaisENaoInformaARua(String nomeCompleto,String cidade,String cep,String pais){
        checkoutStep.preencherFullNameReviewOrder(nomeCompleto);
        checkoutStep.preencherCityInputField(cidade);
        checkoutStep.preencherZipCodeInputField(cep);
        checkoutStep.preencherCountryInputField(pais);
    }

    @And("^o usuario informou o nome completo (.*), rua (.*), cep (.*) e pais (.*) e não informa a cidade$")
    public void oUsuarioInformouONomeCompletoRuaCEPEPaisENaoInformaACidade(String nomeCompleto,String rua,String cep,String pais){
        checkoutStep.preencherFullNameReviewOrder(nomeCompleto);
        checkoutStep.preencherAddressLineOneInputField(rua);
        checkoutStep.preencherZipCodeInputField(cep);
        checkoutStep.preencherCountryInputField(pais);
    }

    @And("^o usuario informou o nome completo (.*), rua (.*), cidade (.*), pais (.*) e não informa o codigo postal$")
    public void oUsuarioInformouONomeCompletoRuaCidadePaisENaoInformaOCodigoPostal(String nomeCompleto,String rua,String cidade,String pais){
        checkoutStep.preencherFullNameReviewOrder(nomeCompleto);
        checkoutStep.preencherAddressLineOneInputField(rua);
        checkoutStep.preencherCityInputField(cidade);
        checkoutStep.preencherCountryInputField(pais);
    }

    @And("^o usuario informou o nome completo (.*), rua (.*), cidade (.*), cep (.*) e não informa o pais$")
    public void oUsuarioInformouONomeCompletoRuaCidadeCEPENaoInformaOPais(String nomeCompleto,String rua,String cidade,String cep){
        checkoutStep.preencherFullNameReviewOrder(nomeCompleto);
        checkoutStep.preencherAddressLineOneInputField(rua);
        checkoutStep.preencherCityInputField(cidade);
        checkoutStep.preencherZipCodeInputField(cep);
    }

}
