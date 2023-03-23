@Repository
public interface CustomerRepository extends MongoRepository<Customer,String>{

    @Aggregation(pipeline = {
            "{ '$match': { 'customerId' : ?0 } }",
            "{ '$sort' : { 'customerId' : 1 } }",
            "{ '$skip' : ?1 }",
            "{ '$limit' : ?2 }"
    })
    List<Customer> findByCustomerId(final String customerId, int skip, int limit);

    @Aggregation(pipeline = {
            "{ '$match': { 'customerId' : ?0 } }",
            "{ '$sort' : { 'customerId' : 1 } }",
            "{ '$skip' : ?1 }"
    })
    Page<Customer> findCustomers(final String customerId, int skip, Pageable pageable);

}