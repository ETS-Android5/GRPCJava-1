// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: envoy/api/v2/auth/cert.proto

package io.grpc.xds.shaded.envoy.api.v2.auth;

public interface CertificateValidationContextOrBuilder extends
    // @@protoc_insertion_point(interface_extends:envoy.api.v2.auth.CertificateValidationContext)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * TLS certificate data containing certificate authority certificates to use in verifying
   * a presented peer certificate (e.g. server certificate for clusters or client certificate
   * for listeners). If not specified and a peer certificate is presented it will not be
   * verified. By default, a client certificate is optional, unless one of the additional
   * options (:ref:`require_client_certificate
   * &lt;envoy_api_field_auth.DownstreamTlsContext.require_client_certificate&gt;`,
   * :ref:`verify_certificate_spki
   * &lt;envoy_api_field_auth.CertificateValidationContext.verify_certificate_spki&gt;`,
   * :ref:`verify_certificate_hash
   * &lt;envoy_api_field_auth.CertificateValidationContext.verify_certificate_hash&gt;`, or
   * :ref:`verify_subject_alt_name
   * &lt;envoy_api_field_auth.CertificateValidationContext.verify_subject_alt_name&gt;`) is also
   * specified.
   * It can optionally contain certificate revocation lists, in which case Envoy will verify
   * that the presented peer certificate has not been revoked by one of the included CRLs.
   * See :ref:`the TLS overview &lt;arch_overview_ssl_enabling_verification&gt;` for a list of common
   * system CA locations.
   * </pre>
   *
   * <code>.envoy.api.v2.core.DataSource trusted_ca = 1;</code>
   */
  boolean hasTrustedCa();
  /**
   * <pre>
   * TLS certificate data containing certificate authority certificates to use in verifying
   * a presented peer certificate (e.g. server certificate for clusters or client certificate
   * for listeners). If not specified and a peer certificate is presented it will not be
   * verified. By default, a client certificate is optional, unless one of the additional
   * options (:ref:`require_client_certificate
   * &lt;envoy_api_field_auth.DownstreamTlsContext.require_client_certificate&gt;`,
   * :ref:`verify_certificate_spki
   * &lt;envoy_api_field_auth.CertificateValidationContext.verify_certificate_spki&gt;`,
   * :ref:`verify_certificate_hash
   * &lt;envoy_api_field_auth.CertificateValidationContext.verify_certificate_hash&gt;`, or
   * :ref:`verify_subject_alt_name
   * &lt;envoy_api_field_auth.CertificateValidationContext.verify_subject_alt_name&gt;`) is also
   * specified.
   * It can optionally contain certificate revocation lists, in which case Envoy will verify
   * that the presented peer certificate has not been revoked by one of the included CRLs.
   * See :ref:`the TLS overview &lt;arch_overview_ssl_enabling_verification&gt;` for a list of common
   * system CA locations.
   * </pre>
   *
   * <code>.envoy.api.v2.core.DataSource trusted_ca = 1;</code>
   */
  io.grpc.xds.shaded.envoy.api.v2.core.DataSource getTrustedCa();
  /**
   * <pre>
   * TLS certificate data containing certificate authority certificates to use in verifying
   * a presented peer certificate (e.g. server certificate for clusters or client certificate
   * for listeners). If not specified and a peer certificate is presented it will not be
   * verified. By default, a client certificate is optional, unless one of the additional
   * options (:ref:`require_client_certificate
   * &lt;envoy_api_field_auth.DownstreamTlsContext.require_client_certificate&gt;`,
   * :ref:`verify_certificate_spki
   * &lt;envoy_api_field_auth.CertificateValidationContext.verify_certificate_spki&gt;`,
   * :ref:`verify_certificate_hash
   * &lt;envoy_api_field_auth.CertificateValidationContext.verify_certificate_hash&gt;`, or
   * :ref:`verify_subject_alt_name
   * &lt;envoy_api_field_auth.CertificateValidationContext.verify_subject_alt_name&gt;`) is also
   * specified.
   * It can optionally contain certificate revocation lists, in which case Envoy will verify
   * that the presented peer certificate has not been revoked by one of the included CRLs.
   * See :ref:`the TLS overview &lt;arch_overview_ssl_enabling_verification&gt;` for a list of common
   * system CA locations.
   * </pre>
   *
   * <code>.envoy.api.v2.core.DataSource trusted_ca = 1;</code>
   */
  io.grpc.xds.shaded.envoy.api.v2.core.DataSourceOrBuilder getTrustedCaOrBuilder();

  /**
   * <pre>
   * An optional list of base64-encoded SHA-256 hashes. If specified, Envoy will verify that the
   * SHA-256 of the DER-encoded Subject Public Key Information (SPKI) of the presented certificate
   * matches one of the specified values.
   * A base64-encoded SHA-256 of the Subject Public Key Information (SPKI) of the certificate
   * can be generated with the following command:
   * .. code-block:: bash
   *   $ openssl x509 -in path/to/client.crt -noout -pubkey &#92;
   *     | openssl pkey -pubin -outform DER &#92;
   *     | openssl dgst -sha256 -binary &#92;
   *     | openssl enc -base64
   *   NvqYIYSbgK2vCJpQhObf77vv+bQWtc5ek5RIOwPiC9A=
   * This is the format used in HTTP Public Key Pinning.
   * When both:
   * :ref:`verify_certificate_hash
   * &lt;envoy_api_field_auth.CertificateValidationContext.verify_certificate_hash&gt;` and
   * :ref:`verify_certificate_spki
   * &lt;envoy_api_field_auth.CertificateValidationContext.verify_certificate_spki&gt;` are specified,
   * a hash matching value from either of the lists will result in the certificate being accepted.
   * .. attention::
   *   This option is preferred over :ref:`verify_certificate_hash
   *   &lt;envoy_api_field_auth.CertificateValidationContext.verify_certificate_hash&gt;`,
   *   because SPKI is tied to a private key, so it doesn't change when the certificate
   *   is renewed using the same private key.
   * </pre>
   *
   * <code>repeated string verify_certificate_spki = 3 [(.validate.rules) = { ... }</code>
   */
  java.util.List<java.lang.String>
      getVerifyCertificateSpkiList();
  /**
   * <pre>
   * An optional list of base64-encoded SHA-256 hashes. If specified, Envoy will verify that the
   * SHA-256 of the DER-encoded Subject Public Key Information (SPKI) of the presented certificate
   * matches one of the specified values.
   * A base64-encoded SHA-256 of the Subject Public Key Information (SPKI) of the certificate
   * can be generated with the following command:
   * .. code-block:: bash
   *   $ openssl x509 -in path/to/client.crt -noout -pubkey &#92;
   *     | openssl pkey -pubin -outform DER &#92;
   *     | openssl dgst -sha256 -binary &#92;
   *     | openssl enc -base64
   *   NvqYIYSbgK2vCJpQhObf77vv+bQWtc5ek5RIOwPiC9A=
   * This is the format used in HTTP Public Key Pinning.
   * When both:
   * :ref:`verify_certificate_hash
   * &lt;envoy_api_field_auth.CertificateValidationContext.verify_certificate_hash&gt;` and
   * :ref:`verify_certificate_spki
   * &lt;envoy_api_field_auth.CertificateValidationContext.verify_certificate_spki&gt;` are specified,
   * a hash matching value from either of the lists will result in the certificate being accepted.
   * .. attention::
   *   This option is preferred over :ref:`verify_certificate_hash
   *   &lt;envoy_api_field_auth.CertificateValidationContext.verify_certificate_hash&gt;`,
   *   because SPKI is tied to a private key, so it doesn't change when the certificate
   *   is renewed using the same private key.
   * </pre>
   *
   * <code>repeated string verify_certificate_spki = 3 [(.validate.rules) = { ... }</code>
   */
  int getVerifyCertificateSpkiCount();
  /**
   * <pre>
   * An optional list of base64-encoded SHA-256 hashes. If specified, Envoy will verify that the
   * SHA-256 of the DER-encoded Subject Public Key Information (SPKI) of the presented certificate
   * matches one of the specified values.
   * A base64-encoded SHA-256 of the Subject Public Key Information (SPKI) of the certificate
   * can be generated with the following command:
   * .. code-block:: bash
   *   $ openssl x509 -in path/to/client.crt -noout -pubkey &#92;
   *     | openssl pkey -pubin -outform DER &#92;
   *     | openssl dgst -sha256 -binary &#92;
   *     | openssl enc -base64
   *   NvqYIYSbgK2vCJpQhObf77vv+bQWtc5ek5RIOwPiC9A=
   * This is the format used in HTTP Public Key Pinning.
   * When both:
   * :ref:`verify_certificate_hash
   * &lt;envoy_api_field_auth.CertificateValidationContext.verify_certificate_hash&gt;` and
   * :ref:`verify_certificate_spki
   * &lt;envoy_api_field_auth.CertificateValidationContext.verify_certificate_spki&gt;` are specified,
   * a hash matching value from either of the lists will result in the certificate being accepted.
   * .. attention::
   *   This option is preferred over :ref:`verify_certificate_hash
   *   &lt;envoy_api_field_auth.CertificateValidationContext.verify_certificate_hash&gt;`,
   *   because SPKI is tied to a private key, so it doesn't change when the certificate
   *   is renewed using the same private key.
   * </pre>
   *
   * <code>repeated string verify_certificate_spki = 3 [(.validate.rules) = { ... }</code>
   */
  java.lang.String getVerifyCertificateSpki(int index);
  /**
   * <pre>
   * An optional list of base64-encoded SHA-256 hashes. If specified, Envoy will verify that the
   * SHA-256 of the DER-encoded Subject Public Key Information (SPKI) of the presented certificate
   * matches one of the specified values.
   * A base64-encoded SHA-256 of the Subject Public Key Information (SPKI) of the certificate
   * can be generated with the following command:
   * .. code-block:: bash
   *   $ openssl x509 -in path/to/client.crt -noout -pubkey &#92;
   *     | openssl pkey -pubin -outform DER &#92;
   *     | openssl dgst -sha256 -binary &#92;
   *     | openssl enc -base64
   *   NvqYIYSbgK2vCJpQhObf77vv+bQWtc5ek5RIOwPiC9A=
   * This is the format used in HTTP Public Key Pinning.
   * When both:
   * :ref:`verify_certificate_hash
   * &lt;envoy_api_field_auth.CertificateValidationContext.verify_certificate_hash&gt;` and
   * :ref:`verify_certificate_spki
   * &lt;envoy_api_field_auth.CertificateValidationContext.verify_certificate_spki&gt;` are specified,
   * a hash matching value from either of the lists will result in the certificate being accepted.
   * .. attention::
   *   This option is preferred over :ref:`verify_certificate_hash
   *   &lt;envoy_api_field_auth.CertificateValidationContext.verify_certificate_hash&gt;`,
   *   because SPKI is tied to a private key, so it doesn't change when the certificate
   *   is renewed using the same private key.
   * </pre>
   *
   * <code>repeated string verify_certificate_spki = 3 [(.validate.rules) = { ... }</code>
   */
  com.google.protobuf.ByteString
      getVerifyCertificateSpkiBytes(int index);

  /**
   * <pre>
   * An optional list of hex-encoded SHA-256 hashes. If specified, Envoy will verify that
   * the SHA-256 of the DER-encoded presented certificate matches one of the specified values.
   * A hex-encoded SHA-256 of the certificate can be generated with the following command:
   * .. code-block:: bash
   *   $ openssl x509 -in path/to/client.crt -outform DER | openssl dgst -sha256 | cut -d" " -f2
   *   df6ff72fe9116521268f6f2dd4966f51df479883fe7037b39f75916ac3049d1a
   * A long hex-encoded and colon-separated SHA-256 (a.k.a. "fingerprint") of the certificate
   * can be generated with the following command:
   * .. code-block:: bash
   *   $ openssl x509 -in path/to/client.crt -noout -fingerprint -sha256 | cut -d"=" -f2
   *   DF:6F:F7:2F:E9:11:65:21:26:8F:6F:2D:D4:96:6F:51:DF:47:98:83:FE:70:37:B3:9F:75:91:6A:C3:04:9D:1A
   * Both of those formats are acceptable.
   * When both:
   * :ref:`verify_certificate_hash
   * &lt;envoy_api_field_auth.CertificateValidationContext.verify_certificate_hash&gt;` and
   * :ref:`verify_certificate_spki
   * &lt;envoy_api_field_auth.CertificateValidationContext.verify_certificate_spki&gt;` are specified,
   * a hash matching value from either of the lists will result in the certificate being accepted.
   * </pre>
   *
   * <code>repeated string verify_certificate_hash = 2 [(.validate.rules) = { ... }</code>
   */
  java.util.List<java.lang.String>
      getVerifyCertificateHashList();
  /**
   * <pre>
   * An optional list of hex-encoded SHA-256 hashes. If specified, Envoy will verify that
   * the SHA-256 of the DER-encoded presented certificate matches one of the specified values.
   * A hex-encoded SHA-256 of the certificate can be generated with the following command:
   * .. code-block:: bash
   *   $ openssl x509 -in path/to/client.crt -outform DER | openssl dgst -sha256 | cut -d" " -f2
   *   df6ff72fe9116521268f6f2dd4966f51df479883fe7037b39f75916ac3049d1a
   * A long hex-encoded and colon-separated SHA-256 (a.k.a. "fingerprint") of the certificate
   * can be generated with the following command:
   * .. code-block:: bash
   *   $ openssl x509 -in path/to/client.crt -noout -fingerprint -sha256 | cut -d"=" -f2
   *   DF:6F:F7:2F:E9:11:65:21:26:8F:6F:2D:D4:96:6F:51:DF:47:98:83:FE:70:37:B3:9F:75:91:6A:C3:04:9D:1A
   * Both of those formats are acceptable.
   * When both:
   * :ref:`verify_certificate_hash
   * &lt;envoy_api_field_auth.CertificateValidationContext.verify_certificate_hash&gt;` and
   * :ref:`verify_certificate_spki
   * &lt;envoy_api_field_auth.CertificateValidationContext.verify_certificate_spki&gt;` are specified,
   * a hash matching value from either of the lists will result in the certificate being accepted.
   * </pre>
   *
   * <code>repeated string verify_certificate_hash = 2 [(.validate.rules) = { ... }</code>
   */
  int getVerifyCertificateHashCount();
  /**
   * <pre>
   * An optional list of hex-encoded SHA-256 hashes. If specified, Envoy will verify that
   * the SHA-256 of the DER-encoded presented certificate matches one of the specified values.
   * A hex-encoded SHA-256 of the certificate can be generated with the following command:
   * .. code-block:: bash
   *   $ openssl x509 -in path/to/client.crt -outform DER | openssl dgst -sha256 | cut -d" " -f2
   *   df6ff72fe9116521268f6f2dd4966f51df479883fe7037b39f75916ac3049d1a
   * A long hex-encoded and colon-separated SHA-256 (a.k.a. "fingerprint") of the certificate
   * can be generated with the following command:
   * .. code-block:: bash
   *   $ openssl x509 -in path/to/client.crt -noout -fingerprint -sha256 | cut -d"=" -f2
   *   DF:6F:F7:2F:E9:11:65:21:26:8F:6F:2D:D4:96:6F:51:DF:47:98:83:FE:70:37:B3:9F:75:91:6A:C3:04:9D:1A
   * Both of those formats are acceptable.
   * When both:
   * :ref:`verify_certificate_hash
   * &lt;envoy_api_field_auth.CertificateValidationContext.verify_certificate_hash&gt;` and
   * :ref:`verify_certificate_spki
   * &lt;envoy_api_field_auth.CertificateValidationContext.verify_certificate_spki&gt;` are specified,
   * a hash matching value from either of the lists will result in the certificate being accepted.
   * </pre>
   *
   * <code>repeated string verify_certificate_hash = 2 [(.validate.rules) = { ... }</code>
   */
  java.lang.String getVerifyCertificateHash(int index);
  /**
   * <pre>
   * An optional list of hex-encoded SHA-256 hashes. If specified, Envoy will verify that
   * the SHA-256 of the DER-encoded presented certificate matches one of the specified values.
   * A hex-encoded SHA-256 of the certificate can be generated with the following command:
   * .. code-block:: bash
   *   $ openssl x509 -in path/to/client.crt -outform DER | openssl dgst -sha256 | cut -d" " -f2
   *   df6ff72fe9116521268f6f2dd4966f51df479883fe7037b39f75916ac3049d1a
   * A long hex-encoded and colon-separated SHA-256 (a.k.a. "fingerprint") of the certificate
   * can be generated with the following command:
   * .. code-block:: bash
   *   $ openssl x509 -in path/to/client.crt -noout -fingerprint -sha256 | cut -d"=" -f2
   *   DF:6F:F7:2F:E9:11:65:21:26:8F:6F:2D:D4:96:6F:51:DF:47:98:83:FE:70:37:B3:9F:75:91:6A:C3:04:9D:1A
   * Both of those formats are acceptable.
   * When both:
   * :ref:`verify_certificate_hash
   * &lt;envoy_api_field_auth.CertificateValidationContext.verify_certificate_hash&gt;` and
   * :ref:`verify_certificate_spki
   * &lt;envoy_api_field_auth.CertificateValidationContext.verify_certificate_spki&gt;` are specified,
   * a hash matching value from either of the lists will result in the certificate being accepted.
   * </pre>
   *
   * <code>repeated string verify_certificate_hash = 2 [(.validate.rules) = { ... }</code>
   */
  com.google.protobuf.ByteString
      getVerifyCertificateHashBytes(int index);

  /**
   * <pre>
   * An optional list of Subject Alternative Names. If specified, Envoy will verify that the
   * Subject Alternative Name of the presented certificate matches one of the specified values.
   * .. attention::
   *   Subject Alternative Names are easily spoofable and verifying only them is insecure,
   *   therefore this option must be used together with :ref:`trusted_ca
   *   &lt;envoy_api_field_auth.CertificateValidationContext.trusted_ca&gt;`.
   * </pre>
   *
   * <code>repeated string verify_subject_alt_name = 4;</code>
   */
  java.util.List<java.lang.String>
      getVerifySubjectAltNameList();
  /**
   * <pre>
   * An optional list of Subject Alternative Names. If specified, Envoy will verify that the
   * Subject Alternative Name of the presented certificate matches one of the specified values.
   * .. attention::
   *   Subject Alternative Names are easily spoofable and verifying only them is insecure,
   *   therefore this option must be used together with :ref:`trusted_ca
   *   &lt;envoy_api_field_auth.CertificateValidationContext.trusted_ca&gt;`.
   * </pre>
   *
   * <code>repeated string verify_subject_alt_name = 4;</code>
   */
  int getVerifySubjectAltNameCount();
  /**
   * <pre>
   * An optional list of Subject Alternative Names. If specified, Envoy will verify that the
   * Subject Alternative Name of the presented certificate matches one of the specified values.
   * .. attention::
   *   Subject Alternative Names are easily spoofable and verifying only them is insecure,
   *   therefore this option must be used together with :ref:`trusted_ca
   *   &lt;envoy_api_field_auth.CertificateValidationContext.trusted_ca&gt;`.
   * </pre>
   *
   * <code>repeated string verify_subject_alt_name = 4;</code>
   */
  java.lang.String getVerifySubjectAltName(int index);
  /**
   * <pre>
   * An optional list of Subject Alternative Names. If specified, Envoy will verify that the
   * Subject Alternative Name of the presented certificate matches one of the specified values.
   * .. attention::
   *   Subject Alternative Names are easily spoofable and verifying only them is insecure,
   *   therefore this option must be used together with :ref:`trusted_ca
   *   &lt;envoy_api_field_auth.CertificateValidationContext.trusted_ca&gt;`.
   * </pre>
   *
   * <code>repeated string verify_subject_alt_name = 4;</code>
   */
  com.google.protobuf.ByteString
      getVerifySubjectAltNameBytes(int index);

  /**
   * <pre>
   * [#not-implemented-hide:] Must present a signed time-stamped OCSP response.
   * </pre>
   *
   * <code>.google.protobuf.BoolValue require_ocsp_staple = 5;</code>
   */
  boolean hasRequireOcspStaple();
  /**
   * <pre>
   * [#not-implemented-hide:] Must present a signed time-stamped OCSP response.
   * </pre>
   *
   * <code>.google.protobuf.BoolValue require_ocsp_staple = 5;</code>
   */
  com.google.protobuf.BoolValue getRequireOcspStaple();
  /**
   * <pre>
   * [#not-implemented-hide:] Must present a signed time-stamped OCSP response.
   * </pre>
   *
   * <code>.google.protobuf.BoolValue require_ocsp_staple = 5;</code>
   */
  com.google.protobuf.BoolValueOrBuilder getRequireOcspStapleOrBuilder();

  /**
   * <pre>
   * [#not-implemented-hide:] Must present signed certificate time-stamp.
   * </pre>
   *
   * <code>.google.protobuf.BoolValue require_signed_certificate_timestamp = 6;</code>
   */
  boolean hasRequireSignedCertificateTimestamp();
  /**
   * <pre>
   * [#not-implemented-hide:] Must present signed certificate time-stamp.
   * </pre>
   *
   * <code>.google.protobuf.BoolValue require_signed_certificate_timestamp = 6;</code>
   */
  com.google.protobuf.BoolValue getRequireSignedCertificateTimestamp();
  /**
   * <pre>
   * [#not-implemented-hide:] Must present signed certificate time-stamp.
   * </pre>
   *
   * <code>.google.protobuf.BoolValue require_signed_certificate_timestamp = 6;</code>
   */
  com.google.protobuf.BoolValueOrBuilder getRequireSignedCertificateTimestampOrBuilder();

  /**
   * <pre>
   * An optional `certificate revocation list
   * &lt;http://https://en.wikipedia.org/wiki/Certificate_revocation_list&gt;`_
   * (in PEM format). If specified, Envoy will verify that the presented peer
   * certificate has not been revoked by this CRL. If this DataSource contains
   * multiple CRLs, all of them will be used.
   * </pre>
   *
   * <code>.envoy.api.v2.core.DataSource crl = 7;</code>
   */
  boolean hasCrl();
  /**
   * <pre>
   * An optional `certificate revocation list
   * &lt;http://https://en.wikipedia.org/wiki/Certificate_revocation_list&gt;`_
   * (in PEM format). If specified, Envoy will verify that the presented peer
   * certificate has not been revoked by this CRL. If this DataSource contains
   * multiple CRLs, all of them will be used.
   * </pre>
   *
   * <code>.envoy.api.v2.core.DataSource crl = 7;</code>
   */
  io.grpc.xds.shaded.envoy.api.v2.core.DataSource getCrl();
  /**
   * <pre>
   * An optional `certificate revocation list
   * &lt;http://https://en.wikipedia.org/wiki/Certificate_revocation_list&gt;`_
   * (in PEM format). If specified, Envoy will verify that the presented peer
   * certificate has not been revoked by this CRL. If this DataSource contains
   * multiple CRLs, all of them will be used.
   * </pre>
   *
   * <code>.envoy.api.v2.core.DataSource crl = 7;</code>
   */
  io.grpc.xds.shaded.envoy.api.v2.core.DataSourceOrBuilder getCrlOrBuilder();

  /**
   * <pre>
   * If specified, Envoy will not reject expired certificates.
   * </pre>
   *
   * <code>bool allow_expired_certificate = 8;</code>
   */
  boolean getAllowExpiredCertificate();
}
