package seek.service;

import io.micronaut.spring.tx.annotation.Transactional;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import seek.domain.dto.PositionDto;
import seek.domain.entity.Position;
import seek.repository.PositionRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Singleton
public class PositionService {

    /**
     * Class logger.
     */
    private static final Logger log = LogManager.getLogger(PositionService.class);


    /**
     * todo Documentation
     */
    @Inject
    protected PositionRepository positionRepository;

    /**
     * todo Documentation
     *
     * @return
     */
    @Transactional
    public List<PositionDto> list() {
        return positionRepository.findAll().stream()
                .map(position -> new PositionDto(position))
                .collect(Collectors.toList());
    }

    /**
     * todo Convert this to DTO.
     *
     * @param id
     * @return
     */
    @Transactional
    public Optional<PositionDto> get(final String id) {
        log.log(Level.DEBUG, String.format("Verifying the provided UUID[value: %s] is valid.", id));
        try {
            final UUID verified = UUID.fromString(id);
            log.log(Level.DEBUG, String.format("%s is valid.", verified.toString()));
            final Optional<Position> result = positionRepository.findById(verified);
            return result.map(PositionDto::new);
        } catch (IllegalArgumentException e) {
            log.log(Level.ERROR, e.getMessage());
            return Optional.empty();
        }
    }

    /**
     * todo Documentation
     *
     * @param position
     * @return
     */
    @Transactional
    public PositionDto save(final Position position) {
        return new PositionDto(positionRepository.save(position));
    }

    /**
     * todo Documentation
     *
     * @param company
     * @return
     */
    @Transactional
    public PositionDto update(final Position company) {
        return new PositionDto(positionRepository.update(company));
    }

    /**
     * todo Documentation
     *
     * @param id
     */
    @Transactional
    public void delete(final UUID id) {
        positionRepository.deleteById(id);
    }
}
