package seek.controller;

import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import seek.domain.dto.PositionDto;
import seek.domain.entity.Position;
import seek.service.PositionService;

import javax.inject.Inject;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * todo documentation
 */
@Controller(value = "/positions")
public class PositionController {

    /**
     * Eligible bean for our position service.
     */
    @Inject
    protected PositionService positionService;

    /**
     * Returns a collection of {@link PositionDto} instances.
     *
     * @return
     */
    @Get(value = "/list")
    @SuppressWarnings("unused")
    public List<PositionDto> list() {
        return positionService.list();
    }

    /**
     * Returns a {@link Position} instance matching the given {@code id}.
     *
     * @param id
     * @return
     */
    @Get("/{id}")
    @SuppressWarnings("unused")
    public HttpResponse<PositionDto> get(final String id) {
        final Optional<PositionDto> result = positionService.get(id);
        if (result.isPresent())
            return HttpResponse.ok(result.get());
        else
            return HttpResponse.notFound();
    }

    /**
     * todo Add validation
     *
     * @param position
     * @return
     */
    @Post
    @SuppressWarnings("unused")
    public HttpResponse<PositionDto> save(@Body Position position) {
        final PositionDto persisted = positionService.save(position);
        return HttpResponse
                .created(persisted)
                .headers(headers -> headers.location(location(position.getId())));
    }

    /**
     * todo Documentation
     *
     * @param position
     * @return
     */
    @Put
    @SuppressWarnings("unused")
    public HttpResponse update(@Body Position position) {
        final PositionDto updated = positionService.update(position);
        return HttpResponse
                .noContent()
                .header(HttpHeaders.LOCATION, location(updated.getId()).getPath());
    }

    /**
     * todo Documentation
     *
     * @param id
     * @return
     */
    @Delete("/{id}")
    @SuppressWarnings("unused")
    public HttpResponse delete(final String id) {
        positionService.delete(UUID.fromString(id));
        return HttpResponse.noContent();
    }

    /**
     * todo Documentation
     *
     * @param id
     * @return
     */
    protected URI location(UUID id) {
        return URI.create("/positions/" + id);
    }

    /**
     * todo Documentation
     *
     * @param position
     * @return
     */
    protected URI location(Position position) {
        return location(position.getId());
    }
}
