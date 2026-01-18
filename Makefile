SRC_DIR := src
BIN_DIR := bin

JAVAC := javac
JAVA  := java

# create bin directory if missing
$(BIN_DIR):
	mkdir -p $(BIN_DIR)

# compile all java sources
.PHONY: build
build: $(BIN_DIR)
	$(JAVAC) -d $(BIN_DIR) $(SRC_DIR)/*.java

# magic: allow `make ClassName`
%: build
	$(JAVA) -cp $(BIN_DIR) $@

# clean build artifacts
.PHONY: clean
clean:
	rm -rf $(BIN_DIR)
