package com.parrot.validation;

import com.parrot.config.ControllerExceptionHandler;

/**
 * This class is a fluent interface that allows you to conditionally return
 * a particular HTTP status. Must be used in conjunction with
 * {@link ControllerExceptionHandler}. Example usage:
 * <code>
 *     Validation
 *	 		.returnStatus(ClientErrorStatusCode.BAD_REQUEST_400)
 *	 		.ifTrue(someExpression)
 *	 		.withErrorMessage("Your request needs some working on")
 *	 		.execute();
 * </code>
 */
public class Validation {

	public static ValidationConditionStep returnStatus(ClientErrorStatusCode statusCode) {
		return new ValidationBuilder(statusCode);
	}

	public interface ValidationConditionStep {
		ValidationWithMessageStep always();
		ValidationWithMessageStep ifTrue(boolean expression);
		ValidationWithMessageStep ifFalse(boolean expression);
		ValidationWithMessageStep ifNull(Object thing);
		ValidationWithMessageStep ifNotNull(Object thing);
	}

	public interface ValidationWithMessageStep {
        ValidationExecuteStep withNoErrorMessage();
		ValidationExecuteStep withErrorMessage(String errorMessage);

	}

	public interface ValidationExecuteStep {
		void execute();
	}

	private static class ValidationBuilder implements ValidationConditionStep, ValidationWithMessageStep, ValidationExecuteStep {
		private boolean shouldThrowException;
		private ClientErrorStatusCode statusToReturn;
		private String errorMessage;

		public ValidationBuilder(ClientErrorStatusCode statusToReturn) {
			this.statusToReturn = statusToReturn;
		}

		@Override
		public ValidationWithMessageStep always() {
			shouldThrowException = true;
			return this;
		}

		@Override
		public ValidationWithMessageStep ifTrue(boolean expression) {
			shouldThrowException = expression;
			return this;
		}

		@Override
		public ValidationWithMessageStep ifFalse(boolean expression) {
			shouldThrowException = ! expression;
			return this;
		}

		@Override
		public ValidationWithMessageStep ifNull(Object thing) {
			shouldThrowException = thing == null;
			return this;
		}

		@Override
		public ValidationWithMessageStep ifNotNull(Object thing) {
			shouldThrowException = thing != null;
			return this;
		}

		@Override
		public ValidationExecuteStep withErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
			return this;
		}

		@Override
		public ValidationExecuteStep withNoErrorMessage() {
			return this;
		}

		@Override
		public void execute() {
			if(shouldThrowException) {
				throw new ClientErrorException(statusToReturn, errorMessage);
			}
		}
	}
}
