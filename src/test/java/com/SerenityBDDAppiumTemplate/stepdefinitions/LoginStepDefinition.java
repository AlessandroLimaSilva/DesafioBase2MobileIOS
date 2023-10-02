package com.SerenityBDDAppiumTemplate.stepdefinitions;

import com.SerenityBDDAppiumTemplate.steps.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class LoginStepDefinition {

    @Steps
    PaginaInicialStep paginaInicialStep;

    @Steps
    MyCartStep myCartStep;

    @Steps
    LoginStep loginStep;

    @Steps
    MenuStep menuStep;

    @And("que tenha acessado o checkout")
    public void queTenhaAcessadoOCheckout(){
        paginaInicialStep.clicarCartButton();
        myCartStep.clicarProceedToCheckoutButton();
    }

    @When("^quando ele informa nome (.*) e senha (.*) não cadastrado$")
    public void quandoEleInformaNomeESenhaNaoCadastrado(String nome,String senha){
        loginStep.preencherUsernameInputField(nome);
        loginStep.preencherPasswordInputField(senha);
        loginStep.clicarLoginButton();
    }

    @Then("ele é informado que o usuario não esta cadastrado")
    public void eleEInformadoQueOUsuarioNaoEstaCadastrado(){
        Assert.assertTrue(loginStep.
                retornaTextoProvidedCredentialsDoNotMatchAnyUserInThisServiceLabel().
                equalsIgnoreCase("Provided credentials do not match any user in this service."));
    }

    @When("^quando ele informa a senha (.*) esquecendo de informar o nome de usuario$")
    public void quandoEleInformaASenhaEsquecendoDeInformarONomeDeUsuario(String senha){
        loginStep.preencherPasswordInputField(senha);
        loginStep.clicarLoginButton();
    }

    @Then("ele é informado que o nome de usuario não foi preenchido")
    public void eleEInformadoQueONomeDeUsuarioNaoFoiPreenchido(){
        Assert.assertTrue(loginStep.
                retornaTextoUsernameIsRequiredLabel().
                equalsIgnoreCase("Username is required"));
    }

    @When("^quando ele informa nome de usuario (.*) esquecendo de informar a senha$")
    public void quandoEleInformaNomeDeUsuarioEsquecensoDeInformarASenha(String usuario){
        loginStep.preencherUsernameInputField(usuario);
        loginStep.clicarLoginButton();
    }

    @Then("ele é informado que a senha não foi preenchida")
    public void eleEInformadoQueASenhaNaoFoiPreenchida(){
        Assert.assertTrue(loginStep.
                retornaTextoPasswordIsRequiredLabel().
                equalsIgnoreCase("Password is required"));
    }

    @When("ele informa um usuario bloqueado")
    public void quandoEleInformaUmUsuarioBloqueado(){
        loginStep.clicarPreencherUsuarioBloqueadoAutomaticamenteButton();
        loginStep.clicarLoginButton();
    }

    @Then("ele é informado que o usuario esta bloqueado")
    public void eleEInformadoQueOUsuarioEstaBloqueado(){
        Assert.assertTrue(loginStep.
                retornaTextoSorryThisUserHasBeenLockedOutLabel().
                equalsIgnoreCase("Sorry, this user has been locked out."));
    }

    @Given("que o usuario realizou o login")
    public void queOUsuarioRealizouOLogin(){
        paginaInicialStep.clicarEmMenuButton();
        menuStep.clicarMenuItemLogInButton();
        loginStep.clicarPreencherUsuarioCadastradoAutomaticamenteButton();
        loginStep.clicarLoginButton();
    }

    @When("quando o usuario seleciona logout")
    public void quandoOUsuarioSelecionaLogout(){
        paginaInicialStep.clicarEmMenuButton();
        menuStep.clicarMenuItemLogOutButton();
        menuStep.clicarLogOutConfirmarButton();
    }

    @Then("o logout é realizado com sucesso")
    public void oLogoutERealizadoComSucesso(){
        Assert.assertTrue(menuStep.
                retornarTextoYouAreSuccessFullyLoggedOutLabel().
                equalsIgnoreCase("You are successfully logged out."));
    }
}
