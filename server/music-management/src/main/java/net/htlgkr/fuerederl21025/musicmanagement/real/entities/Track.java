package net.htlgkr.fuerederl21025.musicmanagement.real.entities;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.Map;
import java.util.Set;


/**
 * This is the Track entity, it is (and also should be) the only Entity stored in the JPA due to the authors inability
 * to properly manage entity relationships, this improves project simplicity at the cost of normalization
 * This hibernation strategy should be seen as a temporary solution, although the author doubts that this temporary
 * solution will ever be changed
 *
 * @author Leo Füreder
 * @version C.D.
 */
@Entity
public class Track extends BaseEntity<Integer> {
    /**
     * ID for JPA to do it's persistence magic
     */
    @Id
    @GeneratedValue
    public Integer id;
    /**
     * This is the name of the track
     */
    @Column(nullable = false)
    @NonNull
    public String name;
    /**
     * This represents the various URLs this Track references, the key of this map is a simple CSV line of Tag strings
     * The obtaining of the right URL out of the map is the responsibility of the client
     * <br/><br/>
     * Example:
     * <code>tag1,tag2,tag3,tag4</code>
     */
    @ElementCollection(fetch = FetchType.EAGER)
    public Map<String, URL> urls;
    @ElementCollection(fetch = FetchType.EAGER)
    public Set<String> tags;
    /**
     * This represents user-defined metadata for each Track object, the metadata needs to be handled by the client, the
     * server only provides queries that lets you search these key-value pairs server-side
     */
    @ElementCollection(fetch = FetchType.EAGER)
    public Map<String, String> metadata;
    public Track(){this.name = "";}
}
@Embeddable
class URL {
    /**
     * The URL string
     */
    public String url;
    /**
     * The mimetype
     */
    public String mime;
}
