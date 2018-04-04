package br.com.mercadinhojt.loja.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.mercadinhojt.mercado.models.Produto;



public class ProdutoValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Produto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(errors, "nome", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "codigoBarras", "field.required");
		
		Produto produto = (Produto) target;
		if(produto.getQuantidade() <= 0){
			errors.rejectValue("quantidade", "field.required");
		}
		
	}

}
