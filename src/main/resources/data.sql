INSERT INTO subscription (
    estado,
    fecha_alta,
    fecha_actualizacion,
    nasdaq_si_status_reason,
    mdw_status_code,
    mdw_business_message_id,
    mdw_response_message,
    mdw_response_datetime,
    nasdaq_si_status
) VALUES (
             'ACTIVO',
             '2024-01-15 10:30:00',
             '2024-01-15 10:30:00',
             'Initial subscription activation',
             200,
             'BUS123456',
             'Successfully activated',
             '2024-01-15T10:30:00',
             'ACTIVE'
         );

INSERT INTO subscription (
    estado,
    fecha_alta,
    fecha_actualizacion,
    nasdaq_si_status_reason,
    mdw_status_code,
    mdw_business_message_id,
    mdw_response_message,
    mdw_response_datetime,
    nasdaq_si_status
) VALUES (
             'SUSPENDIDO',
             '2024-01-10 09:15:00',
             '2024-01-20 14:45:00',
             'Customer requested suspension',
             202,
             'BUS789012',
             'Subscription suspended per customer request',
             '2024-01-20T14:45:00',
             'SUSPENDED'
         );

INSERT INTO subscription (
    estado,
    fecha_alta,
    fecha_actualizacion,
    nasdaq_si_status_reason,
    mdw_status_code,
    mdw_business_message_id,
    mdw_response_message,
    mdw_response_datetime,
    nasdaq_si_status
) VALUES (
             'ACTIVO',
             '2024-01-05 11:00:00',
             '2024-01-21 16:30:00',
             'Renewal processed',
             200,
             'BUS345678',
             'Subscription renewed successfully',
             '2024-01-21T16:30:00',
             'ACTIVE'
         );

INSERT INTO subscription (
    estado,
    fecha_alta,
    fecha_actualizacion,
    nasdaq_si_status_reason,
    mdw_status_code,
    mdw_business_message_id,
    mdw_response_message,
    mdw_response_datetime,
    nasdaq_si_status
) VALUES (
             'CANCELADO',
             '2023-12-01 08:00:00',
             '2024-01-22 09:00:00',
             'Service termination',
             204,
             'BUS901234',
             'Subscription cancelled',
             '2024-01-22T09:00:00',
             'CANCELLED'
         );

INSERT INTO subscription (
    estado,
    fecha_alta,
    fecha_actualizacion,
    nasdaq_si_status_reason,
    mdw_status_code,
    mdw_business_message_id,
    mdw_response_message,
    mdw_response_datetime,
    nasdaq_si_status
) VALUES (
             'ACTIVO',
             '2024-01-22 13:45:00',
             '2024-01-22 13:45:00',
             'New subscription',
             200,
             'BUS567890',
             'New subscription activated',
             '2024-01-22T13:45:00',
             'ACTIVE'
         );