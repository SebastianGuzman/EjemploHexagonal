package com.cbastian90.resources.usecase.createclient;

import com.cbastian90.resources.kernel.command.createperson.CreateClientCommand;
import com.cbastian90.resources.kernel.domain.createclient.CreateClientInformation;
import com.cbastian90.resources.kernel.domain.util.models.Client;
import com.cbastian90.resources.kernel.domain.util.models.Person;
import com.cbastian90.resources.kernel.exception.error.UseCaseErrorResponse;
import com.cbastian90.resources.ports.database.microservicesdb.client.ClientPort;
import io.vavr.control.Either;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CreateClientUseCaseTest {

    private final ClientPort clientPort = Mockito.mock(ClientPort.class);
    private final CreateClientUseCase createClientUseCase = new CreateClientUseCase(clientPort);

    @Test
    public void testExecute() {
        // Crear un comando de prueba
        CreateClientCommand command = CreateClientCommand
                .builder()
                .messageUid("asdf-asdf-gasd-fasd")
                .authorization("234njkwfhnjkewhfkdkjdf")
                .name("John Doe")
                .gender("Male")
                .age(30)
                .identification("123456789")
                .address("123 Main St")
                .phone("123-456-7890")
                .password("password123")
                .estado("active")
                .build();


        // Configurar el repositorio mockeado para devolver un cliente cuando se llama a save
        Client savedClient = Client
                .builder()
                .clientId(1)
                .estado("active")
                .password("password123")
                .person(Person
                        .builder()
                        .personId(1)
                        .name("John Doe")
                        .gender("Male")
                        .age(30)
                        .identification("123456789")
                        .address("123 Main St")
                        .phone("123-456-7890")
                        .personId(1)
                        .build()
                )
                .build();

        when(clientPort.createClient(any(String.class), any(String.class), any(String.class), any(String.class), any(String.class), any(Integer.class), any(String.class), any(String.class))).thenReturn(Mono.just(savedClient));

        // Llamar al método execute
        Either<UseCaseErrorResponse, CreateClientInformation> result = createClientUseCase.execute(command);

        // Verificar que el método createClient del puerto se llamó una vez
        verify(clientPort, times(1)).createClient(any(String.class), any(String.class), any(String.class), any(String.class), any(String.class), any(Integer.class), any(String.class), any(String.class));

        // Asegurarse de que el resultado es el cliente guardado
        assertEquals(savedClient.getClientId(), result.get().getData().getClientId());

        assertNotNull(result.get().getData().getClientId(), "El campo clientId es nulo");
        assertTrue(result.get().getData().getClientId() instanceof Integer, "El campo clientId no es un entero");
        assertEquals("active",result.get().getData().getEstado());
    }
}