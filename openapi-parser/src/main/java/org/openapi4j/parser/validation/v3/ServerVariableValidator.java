package org.openapi4j.parser.validation.v3;

import org.openapi4j.core.validation.ValidationResults;
import org.openapi4j.parser.model.v3.OpenApi3;
import org.openapi4j.parser.model.v3.ServerVariable;
import org.openapi4j.parser.validation.Validator;

import static org.openapi4j.parser.validation.v3.OAI3Keywords.*;

class ServerVariableValidator extends Validator3Base<OpenApi3, ServerVariable> {
  private static final Validator<OpenApi3, ServerVariable> INSTANCE = new ServerVariableValidator();

  private ServerVariableValidator() {
  }

  public static Validator<OpenApi3, ServerVariable> instance() {
    return INSTANCE;
  }

  @Override
  public void validate(OpenApi3 api, final ServerVariable variable, final ValidationResults results) {
    validateList(api, variable.getEnumValues(), results, false, ENUM, null);
    validateString(variable.getDefault(), results, true, DEFAULT);
    validateString(variable.getDescription(), results, false, DESCRIPTION);
  }
}
