package com.parrot.validation;

import org.springframework.http.HttpStatus;

/**
 * List of 4xx http status codes
 * Documentation from https://en.wikipedia.org/wiki/List_of_HTTP_status_codes#4xx_Client_Error
 */
public enum ClientErrorStatusCode {
	/**
	 * The server cannot or will not process the request due to an apparent client error
	 * (e.g., malformed request syntax, too large size, invalid request message framing,
	 * or deceptive request routing)
	 */
	BAD_REQUEST_400(HttpStatus.BAD_REQUEST),

	/**
	 * Similar to 403 Forbidden, but specifically for use when authentication is required
	 * and has failed or has not yet been provided. The response must include a
	 * WWW-Authenticate header field containing a challenge applicable to the requested
	 * resource. See Basic access authentication and Digest access authentication.[33] 401
	 * semantically means "unauthenticated",[34] i.e. the user does not have the necessary
	 * credentials. Note: Some sites issue HTTP 401 when an IP address is banned from the
	 * website (usually the website domain) and that specific address is refused permission
	 * to access a website.
	 */
	UNAUTHORIZED_401(HttpStatus.UNAUTHORIZED),

	/**
	 * Reserved for future use. The original intention was that this code might be used as
	 * part of some form of digital cash or micropayment scheme, but that has not happened,
	 * and this code is not usually used. Google Developers API uses this status if a
	 * particular developer has exceeded the daily limit on requests.
	 */
	PAYMENT_REQUIRED_402(HttpStatus.PAYMENT_REQUIRED),

	/**
	 * The request was a valid request, but the server is refusing to respond to it. The
	 * user might be logged in but does not have the necessary permissions for the resource.
	 */
	FORBIDDEN_403(HttpStatus.FORBIDDEN),

	/**
	 * The requested resource could not be found but may be available in the future.
	 * Subsequent requests by the client are permissible.
	 */
	NOT_FOUND_404(HttpStatus.NOT_FOUND),

	/**
	 * A request method is not supported for the requested resource; for example, a GET
	 * request on a form which requires data to be presented via POST, or a PUT request on a
	 * read-only resource.
	 */
	METHOD_NOT_ALLOWED_405(HttpStatus.METHOD_NOT_ALLOWED),

	/**
	 * The requested resource is capable of generating only content not acceptable according
	 * to the Accept headers sent in the request.
	 */
	NOT_ACCEPTABLE_406(HttpStatus.NOT_ACCEPTABLE),

	/**
	 * The client must first authenticate itself with the proxy.
 	 */
	PROXY_AUTHENTICATION_REQUIRED_407(HttpStatus.PROXY_AUTHENTICATION_REQUIRED),

	/**
	 * The server timed out waiting for the request. According to HTTP specifications: "The
	 * client did not produce a request within the time that the server was prepared to wait.
	 * The client MAY repeat the request without modifications at any later time.
	 */
	REQUEST_TIME_OUT_408(HttpStatus.REQUEST_TIMEOUT),

	/**
	 * Indicates that the request could not be processed because of conflict in the request,
	 * such as an edit conflict between multiple simultaneous updates.
	 */
	CONFLICT_409(HttpStatus.CONFLICT),

	/**
	 * Indicates that the resource requested is no longer available and will not be available
	 * again. This should be used when a resource has been intentionally removed and the
	 * resource should be purged. Upon receiving a 410 status code, the client should not
	 * request the resource in the future. Clients such as search engines should remove the
	 * resource from their indices. Most use cases do not require clients and search engines to
	 * purge the resource, and a "404 Not Found" may be used instead.
	 */
	GONE_410(HttpStatus.GONE),

	/**
	 * The request did not specify the length of its content, which is required by the requested
	 * resource.
	 */
	LENGTH_REQUIRED_411(HttpStatus.LENGTH_REQUIRED),

	/**
	 * The server does not meet one of the preconditions that the requester put on the request.
	 */
	PRECONDITION_FAILED_412(HttpStatus.PRECONDITION_FAILED),

	/**
	 * The request is larger than the server is willing or able to process.
	 */
	PAYLOAD_TOO_LARGE_413(HttpStatus.REQUEST_ENTITY_TOO_LARGE),

	/**
	 * The URI provided was too long for the server to process. Often the result of too much
	 * data being encoded as a query-string of a GET request, in which case it should be
	 * converted to a POST request.
	 */
	URL_TOO_LONG_414(HttpStatus.REQUEST_URI_TOO_LONG),

	/**
	 * The request entity has a media type which the server or resource does not support. For
	 * example, the client uploads an image as image/svg+xml, but the server requires that
	 * images use a different format.
	 */
	UNSUPPORTED_MEDIA_TYPE_415(HttpStatus.UNSUPPORTED_MEDIA_TYPE),

	/**
	 * The client has asked for a portion of the file (byte serving), but the server cannot supply
	 * that portion. For example, if the client asked for a part of the file that lies beyond the
	 * end of the file.
	 */
	RANGE_NOT_SATISFIABLE_416(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE),

	/**
	 * The server cannot meet the requirements of the Expect request-header field.
	 */
	EXPECTATION_FAILED_417(HttpStatus.EXPECTATION_FAILED),

	/**
	 * This code should be returned by teapots requested to brew coffee.
	 */
	IM_A_TEAPOT_418(HttpStatus.I_AM_A_TEAPOT),

	/**
	 * The request was directed at a server that is not able to produce a response (for example
	 * because a connection reuse).
 	 */
	MISDIRECTED_REQUEST_421(HttpStatus.DESTINATION_LOCKED),

	/**
	 * The request was well-formed but was unable to be followed due to semantic errors.
	 */
	UNPROCESSABLE_ENTITY_422(HttpStatus.UNPROCESSABLE_ENTITY),

	/**
	 * The resource that is being accessed is locked.
	 */
	LOCKED_423(HttpStatus.LOCKED),

	/**
	 * The request failed due to failure of a previous request (e.g., a PROPPATCH).
	 */
	FAILED_DEPENDENCY_424(HttpStatus.FAILED_DEPENDENCY),

	/**
	 * The client should switch to a different protocol such as TLS/1.0, given in the Upgrade
	 * header field.
	 */
	UPGRADE_REQUIRED_426(HttpStatus.UPGRADE_REQUIRED),

	/**
	 * The origin server requires the request to be conditional. Intended to prevent "the 'lost
	 * update' problem, where a client GETs a resource's state, modifies it, and PUTs it back to
	 * the server, when meanwhile a third party has modified the state on the server, leading to
	 * a conflict.
	 */
	PRECONDITION_REQUIRED_428(HttpStatus.PRECONDITION_REQUIRED),

	/**
	 * The user has sent too many requests in a given amount of time. Intended for use with
	 * rate-limiting schemes.
	 */
	TOO_MANY_REQUESTS_429(HttpStatus.TOO_MANY_REQUESTS),

	/**
	 * The server is unwilling to process the request because either an individual header field,
	 * or all the header fields collectively, are too large.
	 */
	REQUEST_HEADER_FIELDS_TOO_LARGE_431(HttpStatus.REQUEST_ENTITY_TOO_LARGE);

	private HttpStatus status;

	public HttpStatus getHttpStatus() {
		return status;
	}

	ClientErrorStatusCode(HttpStatus status) {
		this.status = status;
	}
}
